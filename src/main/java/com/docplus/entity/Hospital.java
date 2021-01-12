package com.docplus.entity;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.imifou.jsonschema.module.addon.annotation.JsonSchema;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
@ToString
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"name",
        "description",
        "address",
        "city",
        "telephone",
        "fax",
        "age",
        "email",
        "currencyCod"
})
public class Hospital extends AuditBase {
    @Id
    @NotNull
    @JsonSchema(ignore=true)
    private String id;

    @NotNull
    @JsonSchema(title = "Name", description = "Please enter the hospital name", required = true)
    @JsonPropertyDescription("Name")
    private String name;

    @NotNull
    @JsonSchema(title = "Description", description = "Please enter the hospital description", required = true)
    @JsonPropertyDescription("Description")
    private String description;

    @NotNull
    @JsonSchema(title = "Address", description = "Please enter the hospital address", required = true)
    @JsonPropertyDescription("Address")
    private String address;

    @NotNull
    @JsonSchema(title = "City", description = "Please enter the hospital city name", required = true)
    @JsonPropertyDescription("City")
    private String city;

    @NotNull
    @JsonSchema(title = "Telephone", description = "Please enter the hospital telephone", required = true)
    @JsonPropertyDescription("Telephone")
    private String telephone;

    @NotNull
    @JsonSchema(title = "Fax", description = "Please enter the hospital fax number",defaultValue = "")
    @JsonPropertyDescription("Fax")
    private String fax;

    @NotNull
    @JsonSchema(title = "Email", description = "Please enter the hospital email", required = true,pattern="^(.+)@(.+)$")
    @JsonPropertyDescription("Email")
    @Email
    private String email;

    @NotNull
    @JsonSchema(title = "Currency Code", description = "Please enter the hospital currency code", required = true)
    @JsonPropertyDescription("Currency Code")
    private String currencyCod;
}
