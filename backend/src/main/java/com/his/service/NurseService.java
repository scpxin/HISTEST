package com.his.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.his.entity.Nurse;
import com.his.entity.NursingRecord;
import com.his.entity.Schedule;

import java.util.List;

/**
 * 护士服务接口
 */
public interface NurseService extends IService<Nurse> {

    /**
     * 获取护士列表
     */
    List<Nurse> listNurses(Long departmentId);

    /**
     * 获取排班信息
     */
    List<Schedule> getSchedule(Long staffId, String startDate, String endDate);

    /**
     * 添加排班
     */
    Schedule addSchedule(Schedule schedule);

    /**
     * 获取护理记录
     */
    List<NursingRecord> getCareRecords(Long patientId);

    /**
     * 添加护理记录
     */
    NursingRecord addCareRecord(NursingRecord record);

    /**
     * 获取今日待执行医嘱
     */
    List getTodayMedications(Long nurseId);

    /**
     * 执行医嘱
     */
    void executeMedication(Long id, Long nurseId, String remark);
}
