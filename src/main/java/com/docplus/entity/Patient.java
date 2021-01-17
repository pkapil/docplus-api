package com.docplus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.imifou.jsonschema.module.addon.TypeFormat;
import com.github.imifou.jsonschema.module.addon.annotation.JsonSchema;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
@ToString
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"id","firstName",
        "lastName",
        "middleName",
        "dateOfBirth",
        "patientContactInfo",
        "bloodGroupType",
        "note",
        "age",
        "email",
        "sex",
        "maritalStatus",
        "profession",
        "nextKin",
        "patientNextKinContactInfo",
        "motherName",
        "motherExistence",
        "fatherName",
        "fatherExistence",
        "parentTogether",
        "hasInsurance",
        "taxCode",
        "patientProfilePhoto"
})
public class Patient extends AuditBase {

    @Id
    @NotNull
    @JsonIgnore
    public String _id;

    @NotNull
    @JsonSchema(title = "First Name", description = "Please enter the patient first name", required = true)
    @JsonPropertyDescription("First Name")
    private String firstName;

    @NotNull
    @JsonSchema(title = "Last Name", description = "Please enter the patient last name", required = true)
    private String lastName;

    @JsonSchema(title = "Middle Name", description = "Please enter the patient middle name", defaultValue = "")
    private String middleName;

    @NotNull
    @JsonSchema(title = "DOB", description = "Please enter the patient date of birth", required = true, format = TypeFormat.DATE_TIME)
    private LocalDateTime dateOfBirth;

    @NotNull
    @JsonSchema(title = "Blood Type", description = "Please enter the patient blood group", required = true)
    private BloodGroupType bloodGroupType;

    @NotNull
    @Positive
    @Min(value = 0L)
    @Max(value = 120L)
    @JsonSchema(title = "Age", description = "Please enter the patient age", required = true, min = 0, max = 120)
    private int age;

    @Email
    @JsonSchema(title = "Email", description = "Please enter the patient email", required = true)
    private String email;

    @NotNull
    @JsonSchema(title = "Gender", description = "Please enter the patient gender", required = true)
    private SexType sex;

    @JsonSchema(title = "Patient Notes ", description = "Patient notes")
    private List<Note> note = new ArrayList<>();

    @JsonSchema(title = "Patient Contact Info", description = "Please provide patient primary contact info", required = true)
    private ContactInfo patientContactInfo;

    @NotNull
    @JsonSchema(title = "Patient Mother Name", description = "Please provide patient mother name", defaultValue = "")
    private String motherName; // mother's name

    @JsonSchema(title = "Is Patient's Mother Alive?", description = "Please provide patient mother existence details", defaultValue = "NOT_ENTERED")
    private ExistenceType motherExistence = ExistenceType.NOT_ENTERED;// D=dead, A=alive

    @NotNull
    @JsonSchema(title = "Patient Mother Name", description = "Please provide patient father name", defaultValue = "")
    private String fatherName; // father's name

    @NotNull
    @JsonSchema(title = "Is Patient's Father Alive?", description = "Please provide patient father existence details", defaultValue = "NOT_ENTERED")
    private ExistenceType fatherExistence = ExistenceType.NOT_ENTERED; // father's name

    @JsonSchema(title = "Are parents living together? ", description = "Patient parents details", defaultValue = "NOT_ENTERED")
    private ExistenceType parentTogether = ExistenceType.NOT_ENTERED; // parents together: Y or N

    @JsonSchema(title = "Does Patient has Insurance", description = "Patient insurance details", defaultValue = "NOT_ENTERED")
    private ExistenceType hasInsurance = ExistenceType.NOT_ENTERED; // Y=Yes, N=no

    @JsonSchema(title = "Next Kin Name", description = "Please enter next kin name", defaultValue = "")
    private String nextKin;

    @JsonSchema(title = "Patient next Kin Details ", description = "Patient next kin details", defaultValue = "")
    private ContactInfo patientNextKinContactInfo;

    @JsonSchema(title = "Patient Tax Code", description = "Provide patient Patient tax code details", defaultValue = "")
    private String taxCode;

    @NotEmpty
    @JsonSchema(title = "Martial Status", description = "Provide patient Martial status", defaultValue = "")
    private String maritalStatus;

    @NotEmpty
    @JsonSchema(title = "Profession", description = "Provide patient profession", defaultValue = "")
    private String profession;

    @JsonIgnore
    @JsonSchema(ignore = true)
    @NotNull
    private ExistenceType deleted = ExistenceType.NO;

    @JsonSchema(title = "Patient Profile Photo", description = "Provide patient profile photo", defaultValue = "")
    private PatientProfilePhoto patientProfilePhoto;

}