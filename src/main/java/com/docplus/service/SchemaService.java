package com.docplus.service;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.imifou.jsonschema.module.addon.AddonModule;
import com.github.victools.jsonschema.generator.*;
import com.github.victools.jsonschema.module.javax.validation.JavaxValidationModule;
import com.github.victools.jsonschema.module.javax.validation.JavaxValidationOption;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class SchemaService {

    public String getSchemaFromClass(Class clazz) throws IOException {
        AddonModule module1 = new AddonModule();
        JavaxValidationModule module = new JavaxValidationModule(JavaxValidationOption.INCLUDE_PATTERN_EXPRESSIONS);
        SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2019_09, OptionPreset.PLAIN_JSON)
                .with(module).with(module1);
        SchemaGeneratorConfig config = configBuilder.build();
        SchemaGenerator generator = new SchemaGenerator(config);
        ObjectNode jsonSchema = generator.generateSchema(clazz);
//        String[] values = new String[]{};
//        Annotation[] annotatedTypes = clazz.getAnnotations();
//        for (Annotation val : annotatedTypes) {
//            if (val instanceof JsonPropertyOrder) {
//                ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(((JsonPropertyOrder) val).value()));
//                arrayList.add("*");
//                jsonSchema.putArray("ui:order").add(new ObjectMapper().valueToTree(
//                        arrayList));
//            }
//        }
        return jsonSchema.toString();
    }
}
