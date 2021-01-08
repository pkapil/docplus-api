package com.docplus.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
@ToString
@EqualsAndHashCode(callSuper = false)
public class Hospital extends AuditBase {
    @Id
    private String id;
    private String description;
    private String address;
    private String city;
    private String telephone;
    private String fax;
    private String email;
    private String currencyCod;
}
