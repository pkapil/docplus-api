package com.docplus.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SexType {
    MALE('M'), FEMALE('F'), NOT_ENTERED(' ');
    @Getter
    private char value;
}
