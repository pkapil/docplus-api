package com.docplus.entity;


import lombok.Data;
import org.springframework.data.annotation.*;

import java.time.Instant;

@Data
public class AuditBase {

    @CreatedBy
    private String creator;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private Instant lastModification;

    @CreatedDate
    private Instant creationDate;

    @Version
    private Long version;

}