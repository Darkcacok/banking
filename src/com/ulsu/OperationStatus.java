package com.ulsu;

public enum OperationStatus{

    PENDING("В процессе"),
    SUCCESS("Успешно"),
    FAILED("Отклонено");

    private String value;

    public String getValue() {
        return value;
    }

    OperationStatus(String value) {
        this.value = value;
    }
}
