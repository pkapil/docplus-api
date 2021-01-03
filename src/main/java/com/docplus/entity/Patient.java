package com.docplus.entity;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.github.imifou.jsonschema.module.addon.annotation.JsonSchema;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
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
    @NotNull
    private String id;

    @NotNull
    @JsonSchema(title="First Name",description = "Please enter the patient first name",required = true)
    @JsonPropertyDescription("First Name")
    private String firstName;

    @NotNull
    @JsonSchema(title="Last Name",description = "Please enter the patient last name",required = true)
    private String lastName;

    @JsonSchema(title="Middle Name",description = "Please enter the patient middle name")
    private String middleName;

    @NotNull
    @JsonSchema(title="DOB",description = "Please enter the patient date of birth",required = true)
    private LocalDate dateOfBirth;

    @NotNull
    @JsonSchema(title="Blood Type",description = "Please enter the patient blood group",required = true)
    private BloodGroupType bloodGroupType;

    @NotNull
    @Positive
    @Min(value = 0L)
    @Max(value = 120L)
    @JsonSchema(title="Blood Type",description = "Please enter the patient blood group",required = true,min = 0,max = 120)
    private int age;

    @Email
    @JsonSchema(title="Email",description = "Please enter the patient email",required = true)
    private String email;

    @NotNull
    @JsonSchema(title="Gender",description = "Please enter the patient gender",required = true)
    private SexType sex;

    @JsonSchema(title="Next Kin Name",description = "Please enter next kin name")
    private String nextKin;

    private List<String> note;
    @JsonSchema(title="Patient Contact Info",description = "Please provide patient primary contact info")
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
    @NotEmpty
    private String maritalStatus;
    @NotEmpty
    private String profession;

    @JsonIgnore
    @JsonSchema(ignore=true)
    @NotNull
    private ExistenceType deleted = ExistenceType.NO;

    private PatientProfilePhoto patientProfilePhoto;

}