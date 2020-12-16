package com.docplus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactInfo {
    private ContactInfoType contactInfoType = ContactInfoType.PRIMARY;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String landMark;
    private String state;
    private String country;
    private String telephonePrimary;
    private String telephoneSecondary;
    private Integer zipCode;
}