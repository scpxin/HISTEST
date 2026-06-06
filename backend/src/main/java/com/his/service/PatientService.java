package com.his.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.his.entity.Patient;
import java.util.List;

public interface PatientService extends IService<Patient> {
    IPage<Patient> listPatients(Integer page, Integer size, String keyword);
    Patient getPatientById(Long id);
    Patient createPatient(Patient patient);
    Patient updatePatient(Patient patient);
    void deletePatient(Long id);
    List<Patient> getInpatients();
}
