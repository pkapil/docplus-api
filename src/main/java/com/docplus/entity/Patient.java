package com.docplus.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
@ToString
public class Patient extends AuditBase {

    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    @NotNull
    private String id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String middleName;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private BloodGroupType bloodGroupType;

    private String secondName;

    @NotNull
    private int age;

    @NotNull
    private SexType sex;


    private String nextKin;

    private List<String> note;

    private ContactInfo patientContactInfo;

    @NotNull
    private String motherName; // mother's name

    private ExistenceType motherExistence = ExistenceType.NOT_ENTERED;// D=dead, A=alive

    @NotNull
    private ExistenceType fatherExistence = ExistenceType.NOT_ENTERED; // father's name

    @NotNull
    private String fatherName; // father's name

    private ExistenceType hasInsurance = ExistenceType.NOT_ENTERED; // Y=Yes, N=no

    private ExistenceType parentTogether = ExistenceType.NOT_ENTERED; // parents together: Y or N

    private ContactInfo patientNextKinContactInfo;

    private String taxCode;

    private String maritalStatus;

    private String profession;

    @NotNull
    private ExistenceType deleted = ExistenceType.NO;

    private PatientProfilePhoto patientProfilePhoto;

}