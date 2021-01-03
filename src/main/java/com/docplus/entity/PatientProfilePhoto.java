package com.docplus.entity;

import com.github.imifou.jsonschema.module.addon.annotation.JsonSchema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientProfilePhoto {
    @JsonSchema(title="Photo",description = "Provide photo as upload")
    private String photo;

}