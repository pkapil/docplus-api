package com.docplus.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.imifou.jsonschema.module.addon.annotation.JsonSchema;
import lombok.Data;
import org.springframework.data.annotation.*;

import java.time.Instant;

@Data
public class AuditBase {
    @JsonIgnore
    @JsonSchema(ignore = true)
    @CreatedBy
    private String creator;
    @JsonIgnore
    @JsonSchema(ignore = true)
    @LastModifiedBy
    private String lastModifiedBy;
    @JsonIgnore
    @JsonSchema(ignore = true)
    @LastModifiedDate
    private Instant lastModification;
    @JsonIgnore
    @JsonSchema(ignore = true)
    @CreatedDate
    private Instant creationDate;
    @JsonIgnore
    @JsonSchema(ignore = true)
    @Version
    private Long version;

}