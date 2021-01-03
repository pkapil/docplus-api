package com.docplus.entity;

import com.github.imifou.jsonschema.module.addon.annotation.JsonSchema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactInfo {
    @JsonSchema(title="Contact Type",description = "Provide type of the contact primary, secondary..etc",required = true)
    private ContactInfoType contactInfoType = ContactInfoType.PRIMARY;
    @JsonSchema(title="Address Line1",description = "Provide address line 1", required = true)
    private String addressLine1;
    @JsonSchema(title="Address Line2",description = "Provide address line 2")
    private String addressLine2;
    @JsonSchema(title="City",description = "city")
    private String city;
    @JsonSchema(title="Nearby Land Mark",description = "Provide nearest landmark")
    private String landMark;
    @JsonSchema(title="State",description = "Provide state")
    private String state;
    @JsonSchema(title="Country",description = "Provide country")
    private String country;
    @JsonSchema(title="Telephone primary",description = "Provide state", required = true)
    private String telephonePrimary;
    @JsonSchema(title="Telephone secondary",description = "Provide state")
    private String telephoneSecondary;
    @JsonSchema(title="Zip",description = "Provide zip code", required = true)
    private Integer zipCode;
}