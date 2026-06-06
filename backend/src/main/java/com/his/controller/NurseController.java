package com.his.controller;

import com.his.common.Result;
import com.his.entity.Nurse;
import com.his.entity.NursingRecord;
import com.his.entity.Schedule;
import com.his.service.NurseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 护士站控制器
 */
@Tag(name = "护士站", description = "护士工作站相关接口")
@RestController
@RequestMapping("/nurse")
@RequiredArgsConstructor
public class NurseController {

    private final NurseService nurseService;

    @Operation(summary = "获取护士列表")
    @GetMapping("/list")
    public Result<List<Nurse>> list(@RequestParam(required = false) Long departmentId) {
        List<Nurse> nurses = nurseService.listNurses(departmentId);
        return Result.success(nurses);
    }

    @Operation(summary = "获取排班信息")
    @GetMapping("/schedule")
    public Result<List<Schedule>> getSchedule(
            @RequestParam(required = false) Long staffId,
            @RequestParam String startDate,
            @RequestParam String endDate) {
        List<Schedule> schedules = nurseService.getSchedule(staffId, startDate, endDate);
        return Result.success(schedules);
    }

    @Operation(summary = "添加排班")
    @PostMapping("/schedule")
    public Result<Schedule> addSchedule(@RequestBody Schedule schedule) {
        Schedule created = nurseService.addSchedule(schedule);
        return Result.success(created);
    }

    @Operation(summary = "获取护理记录")
    @GetMapping("/care-records")
    public Result<List<NursingRecord>> getCareRecords(@RequestParam Long patientId) {
        List<NursingRecord> records = nurseService.getCareRecords(patientId);
        return Result.success(records);
    }

    @Operation(summary = "添加护理记录")
    @PostMapping("/care-records")
    public Result<NursingRecord> addCareRecord(@RequestBody NursingRecord record) {
        NursingRecord created = nurseService.addCareRecord(record);
        return Result.success(created);
    }

    @Operation(summary = "获取今日待执行医嘱")
    @GetMapping("/medications/today")
    public Result<List> getTodayMedications(@RequestParam(required = false) Long nurseId) {
        List medications = nurseService.getTodayMedications(nurseId);
        return Result.success(medications);
    }

    @Operation(summary = "执行医嘱")
    @PostMapping("/medications/{id}/execute")
    public Result<Void> executeMedication(
            @PathVariable Long id,
            @RequestParam Long nurseId,
            @RequestParam(required = false) String remark) {
        nurseService.executeMedication(id, nurseId, remark);
        return Result.success(null);
    }
}
