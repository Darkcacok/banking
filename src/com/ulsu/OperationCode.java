package com.ulsu;

public enum OperationCode{

    PULL("Поступление денег"),
    PUSH("Передача денег"),
    CHECK_BALANCE("Получение баланса");

    private String value;

    public String getValue() {
        return value;
    }

    OperationCode(String value) {
        this.value = value;
    }
}
