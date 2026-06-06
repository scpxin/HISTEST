package com.his.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.his.entity.Appointment;
import com.his.entity.Doctor;
import com.his.entity.Schedule;

import java.util.List;

/**
 * 医生服务接口
 */
public interface DoctorService extends IService<Doctor> {

    /**
     * 获取医生列表
     */
    List<Doctor> listDoctors(Long departmentId);

    /**
     * 获取今日预约列表
     */
    List<Appointment> getTodayAppointments(Long doctorId);

    /**
     * 获取医生排班
     */
    List<Schedule> getSchedule(Long doctorId, String startDate, String endDate);

    /**
     * 叫号 - 叫下一个患者
     */
    Appointment callNextPatient(Long doctorId);

    /**
     * 完成就诊
     */
    void completeAppointment(Long appointmentId);
}
