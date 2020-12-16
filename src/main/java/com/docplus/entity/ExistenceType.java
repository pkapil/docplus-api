package com.docplus.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ExistenceType {
    YES('Y'), NO('N'), NOT_ENTERED(' ');
    @Getter
    private char value;
}
