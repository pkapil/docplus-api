package com.docplus.controller;

import com.docplus.entity.Hospital;
import com.docplus.entity.Patient;
import com.docplus.service.SchemaService;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.imifou.jsonschema.module.addon.AddonModule;
import com.github.victools.jsonschema.generator.*;
import com.github.victools.jsonschema.module.javax.validation.JavaxValidationModule;
import com.github.victools.jsonschema.module.javax.validation.JavaxValidationOption;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;

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

}
