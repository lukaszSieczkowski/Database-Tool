package com.example.domain.model;

public enum SheetNames {
    JAVA_BASIC_QUESTIONS_PL("java_basic_questions_pl"), JAVA_BASIC_QUESTIONS_EN("java_basic_questions_en");

    private final String value;

    SheetNames(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
