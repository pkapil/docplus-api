package com.docplus.controller;

import com.docplus.entity.Hospital;
import com.docplus.entity.Patient;
import com.docplus.entity.VitalInfo;
import com.docplus.service.SchemaService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Log4j2
public class FormsController {

    @Autowired
    SchemaService schemaService;

    @GetMapping("/forms/patient")
    public ResponseEntity<?> getPatientForm() throws IOException {
        return ResponseEntity.ok(schemaService.getSchemaFromClass(Patient.class));
    }

    @GetMapping("/forms/hospital")
    public ResponseEntity<?> getHospitalForm() throws IOException {
        return ResponseEntity.ok(schemaService.getSchemaFromClass(Hospital.class));
    }

    @GetMapping("/forms/vitalinfo")
    public ResponseEntity<?> getVitalInfoForm() throws IOException {
        return ResponseEntity.ok(schemaService.getSchemaFromClass(VitalInfo.class));
    }
}
