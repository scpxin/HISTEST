package com.his.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.his.entity.Patient;
import com.his.mapper.PatientMapper;
import com.his.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements PatientService {

    @Override
    public IPage<Patient> listPatients(Integer page, Integer size, String keyword) {
        Page<Patient> pageParam = new Page<>(page, size);
        LambdaQueryWrapper<Patient> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasText(keyword)) {
            wrapper.like(Patient::getName, keyword)
                   .or()
                   .like(Patient::getPatientNo, keyword)
                   .or()
                   .like(Patient::getPhone, keyword);
        }
        wrapper.orderByDesc(Patient::getCreateTime);
        return this.page(pageParam, wrapper);
    }

    @Override
    public Patient getPatientById(Long id) {
        return this.getById(id);
    }

    @Override
    public Patient createPatient(Patient patient) {
        if (!StringUtils.hasText(patient.getPatientNo())) {
            patient.setPatientNo("P" + System.currentTimeMillis());
        }
        this.save(patient);
        return patient;
    }

    @Override
    public Patient updatePatient(Patient patient) {
        this.updateById(patient);
        return patient;
    }

    @Override
    public void deletePatient(Long id) {
        this.removeById(id);
    }

    @Override
    public List<Patient> getInpatients() {
        LambdaQueryWrapper<Patient> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Patient::getStatus, 1).orderByDesc(Patient::getCreateTime);
        return this.list(wrapper);
    }
}
