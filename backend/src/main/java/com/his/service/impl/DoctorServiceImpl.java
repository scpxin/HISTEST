package com.his.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.his.entity.Appointment;
import com.his.entity.Doctor;
import com.his.entity.Schedule;
import com.his.mapper.AppointmentMapper;
import com.his.mapper.DoctorMapper;
import com.his.mapper.ScheduleMapper;
import com.his.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {

    private final AppointmentMapper appointmentMapper;
    private final ScheduleMapper scheduleMapper;

    @Override
    public List<Doctor> listDoctors(Long departmentId) {
        LambdaQueryWrapper<Doctor> wrapper = new LambdaQueryWrapper<>();
        if (departmentId != null) {
            wrapper.eq(Doctor::getDepartmentId, departmentId);
        }
        wrapper.eq(Doctor::getStatus, 1).orderByDesc(Doctor::getCreateTime);
        return this.list(wrapper);
    }

    @Override
    public List<Appointment> getTodayAppointments(Long doctorId) {
        LambdaQueryWrapper<Appointment> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Appointment::getDoctorId, doctorId)
               .eq(Appointment::getAppointmentDate, LocalDate.now())
               .orderByAsc(Appointment::getCreateTime);
        return appointmentMapper.selectList(wrapper);
    }

    @Override
    public List<Schedule> getSchedule(Long doctorId, String startDate, String endDate) {
        LambdaQueryWrapper<Schedule> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Schedule::getStaffId, doctorId)
               .orderByAsc(Schedule::getScheduleDate);
        return scheduleMapper.selectList(wrapper);
    }

    @Override
    public Appointment callNextPatient(Long doctorId) {
        LambdaQueryWrapper<Appointment> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Appointment::getDoctorId, doctorId)
               .eq(Appointment::getStatus, 1)
               .orderByAsc(Appointment::getCreateTime);
        return appointmentMapper.selectOne(wrapper);
    }

    @Override
    public void completeAppointment(Long appointmentId) {
        Appointment appointment = appointmentMapper.selectById(appointmentId);
        if (appointment != null) {
            appointment.setStatus(2);
            appointmentMapper.updateById(appointment);
        }
    }
}
