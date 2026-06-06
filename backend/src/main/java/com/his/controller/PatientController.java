package com.his.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.his.common.Result;
import com.his.entity.Patient;
import com.his.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/list")
    public Result<IPage<Patient>> list(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String keyword) {
        IPage<Patient> result = patientService.listPatients(page, size, keyword);
        return Result.success(result);
    }

    @GetMapping("/{id}")
    public Result<Patient> getById(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            return Result.success(patient);
        }
        return Result.error("患者不存在");
    }

    @PostMapping
    public Result<Patient> create(@RequestBody Patient patient) {
        Patient created = patientService.createPatient(patient);
        return Result.success(created);
    }

    @PutMapping("/{id}")
    public Result<Patient> update(@PathVariable Long id, @RequestBody Patient patient) {
        patient.setId(id);
        Patient updated = patientService.updatePatient(patient);
        return Result.success(updated);
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        patientService.deletePatient(id);
        return Result.success(null);
    }

    @GetMapping("/inpatients")
    public Result<List<Patient>> getInpatients() {
        List<Patient> inpatients = patientService.getInpatients();
        return Result.success(inpatients);
    }
}
