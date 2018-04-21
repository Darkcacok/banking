package com.ulsu.common;

/**
 * статус счета
 */

public enum AccountStatus {
    ACTIVE("Активный"),
    LOCKED("Заблокирован");

    private String value;

    public String getValue() {
        return value;
    }

    AccountStatus(String value) {
        this.value = value;
    }
}
