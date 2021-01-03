package com.docplus.controller;

import com.docplus.entity.Hospital;
import com.docplus.entity.Patient;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;

@RestController
@Log4j2
public class FormsController {




    @GetMapping("/forms/patient")
    public ResponseEntity<?> getPatientForm() throws JsonProcessingException {
        return getSchemaFromClass(Patient.class);
    }

    @GetMapping("/forms/hospital")
    public ResponseEntity<?> getHospitalForm() throws JsonProcessingException {
        return getSchemaFromClass(Hospital.class);
    }

    private ResponseEntity<String> getSchemaFromClass(Class clazz) throws JsonProcessingException {
        AddonModule module1 = new AddonModule();
        JavaxValidationModule module = new JavaxValidationModule(JavaxValidationOption.INCLUDE_PATTERN_EXPRESSIONS);
        SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2019_09, OptionPreset.PLAIN_JSON)
                .with(module).with(module1);
        SchemaGeneratorConfig config = configBuilder.build();
        SchemaGenerator generator = new SchemaGenerator(config);
        JsonNode jsonSchema = generator.generateSchema(clazz);
        String[] values=new String[]{};
        Annotation[] annotatedTypes= clazz.getAnnotations();
        if(annotatedTypes.length>0){
            for(Annotation val : annotatedTypes) {
               if(val instanceof JsonPropertyOrder)
               {
                  values=  ((JsonPropertyOrder) val).value();
                   ((ObjectNode) jsonSchema).put("ui:order", new ObjectMapper().writeValueAsString(values));
               }
            }
        }
        System.out.println(jsonSchema.toString());
        return  ResponseEntity.ok(jsonSchema.toString());
    }
}
