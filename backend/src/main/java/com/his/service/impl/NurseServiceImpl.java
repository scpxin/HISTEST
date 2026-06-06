package com.his.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.his.entity.Nurse;
import com.his.entity.NursingRecord;
import com.his.entity.Schedule;
import com.his.mapper.NurseMapper;
import com.his.mapper.NursingRecordMapper;
import com.his.mapper.ScheduleMapper;
import com.his.service.NurseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NurseServiceImpl extends ServiceImpl<NurseMapper, Nurse> implements NurseService {

    private final ScheduleMapper scheduleMapper;
    private final NursingRecordMapper nursingRecordMapper;

    @Override
    public List<Nurse> listNurses(Long departmentId) {
        LambdaQueryWrapper<Nurse> wrapper = new LambdaQueryWrapper<>();
        if (departmentId != null) {
            wrapper.eq(Nurse::getDepartmentId, departmentId);
        }
        wrapper.eq(Nurse::getStatus, 1).orderByDesc(Nurse::getCreateTime);
        return this.list(wrapper);
    }

    @Override
    public List<Schedule> getSchedule(Long staffId, String startDate, String endDate) {
        LambdaQueryWrapper<Schedule> wrapper = new LambdaQueryWrapper<>();
        if (staffId != null) {
            wrapper.eq(Schedule::getStaffId, staffId);
        }
        wrapper.orderByAsc(Schedule::getScheduleDate);
        return scheduleMapper.selectList(wrapper);
    }

    @Override
    public Schedule addSchedule(Schedule schedule) {
        scheduleMapper.insert(schedule);
        return schedule;
    }

    @Override
    public List<NursingRecord> getCareRecords(Long patientId) {
        LambdaQueryWrapper<NursingRecord> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(NursingRecord::getPatientId, patientId)
               .orderByDesc(NursingRecord::getCreateTime);
        return nursingRecordMapper.selectList(wrapper);
    }

    @Override
    public NursingRecord addCareRecord(NursingRecord record) {
        nursingRecordMapper.insert(record);
        return record;
    }

    @Override
    public List getTodayMedications(Long nurseId) {
        return List.of();
    }

    @Override
    public void executeMedication(Long id, Long nurseId, String remark) {
    }
}
