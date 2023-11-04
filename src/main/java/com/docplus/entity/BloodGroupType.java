package com.docplus.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum BloodGroupType {
    B_POSITIVE("B+"), B_NEGITIVE("B-"), A_POSITIVE("A+"), A_NEGITIVE("A-"), SHASHI_POSITVE("S+");
    @Getter
    private String value;
}
