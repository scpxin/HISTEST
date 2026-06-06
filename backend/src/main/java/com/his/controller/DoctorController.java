package com.his.controller;

import com.his.common.Result;
import com.his.entity.Appointment;
import com.his.entity.Doctor;
import com.his.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 医生站控制器
 */
@Tag(name = "医生站", description = "医生工作站相关接口")
@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @Operation(summary = "获取医生列表")
    @GetMapping("/list")
    public Result<List<Doctor>> list(@RequestParam(required = false) Long departmentId) {
        List<Doctor> doctors = doctorService.listDoctors(departmentId);
        return Result.success(doctors);
    }

    @Operation(summary = "获取今日预约列表")
    @GetMapping("/appointments/today")
    public Result<List<Appointment>> getTodayAppointments(
            @RequestParam Long doctorId) {
        List<Appointment> appointments = doctorService.getTodayAppointments(doctorId);
        return Result.success(appointments);
    }

    @Operation(summary = "获取医生排班")
    @GetMapping("/schedule")
    public Result<List> getSchedule(
            @RequestParam Long doctorId,
            @RequestParam String startDate,
            @RequestParam String endDate) {
        List schedule = doctorService.getSchedule(doctorId, startDate, endDate);
        return Result.success(schedule);
    }

    @Operation(summary = "叫号 - 叫下一个患者")
    @PostMapping("/call-next")
    public Result<Appointment> callNextPatient(@RequestParam Long doctorId) {
        Appointment appointment = doctorService.callNextPatient(doctorId);
        if (appointment != null) {
            return Result.success(appointment);
        }
        return Result.error("没有待就诊的患者");
    }

    @Operation(summary = "完成就诊")
    @PostMapping("/complete/{appointmentId}")
    public Result<Void> completeAppointment(@PathVariable Long appointmentId) {
        doctorService.completeAppointment(appointmentId);
        return Result.success(null);
    }
}
