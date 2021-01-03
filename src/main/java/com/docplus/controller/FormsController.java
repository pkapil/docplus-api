package com.docplus.controller;

import com.docplus.entity.Hospital;
import com.docplus.entity.Patient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.github.imifou.jsonschema.module.addon.AddonModule;
import com.github.victools.jsonschema.generator.*;
import com.github.victools.jsonschema.module.javax.validation.JavaxValidationModule;
import com.github.victools.jsonschema.module.javax.validation.JavaxValidationOption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormsController {


    @GetMapping("/forms/patient")
    public ResponseEntity<?> getPatientForm() throws JsonProcessingException {
        return getSchemaFromClass(Patient.class);
    }

    @GetMapping("/forms/hospital")
    public ResponseEntity<?> getHospitalForm() throws JsonProcessingException {
        return getSchemaFromClass(Hospital.class);
    }

    private ResponseEntity<String> getSchemaFromClass(Class clazz) {
        AddonModule module1 = new AddonModule();
        JavaxValidationModule module = new JavaxValidationModule(JavaxValidationOption.INCLUDE_PATTERN_EXPRESSIONS);
        SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2019_09, OptionPreset.PLAIN_JSON).with(module).with(module1);
        SchemaGeneratorConfig config = configBuilder.build();
        SchemaGenerator generator = new SchemaGenerator(config);
        JsonNode jsonSchema = generator.generateSchema(clazz);
        System.out.println(jsonSchema.toString());
        return  ResponseEntity.ok(jsonSchema.toString());
    }
}
