package com.ulsu;

import java.time.LocalDateTime;
import java.util.Date;

public class OperationHistory{
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OperationCode getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(OperationCode operationCode) {
        this.operationCode = operationCode;
    }

    public void setOperationStatus(OperationStatus operationStatus) {
        this.operationStatus = operationStatus;
    }

    Account account;
    LocalDateTime date;
    int id;
    OperationCode operationCode;
    OperationStatus operationStatus;

    public OperationHistory(Account account, LocalDateTime date, OperationCode operationCode, OperationStatus operationStatus)
    {
        this.account = account;
        this.date = date;
        this.operationCode = operationCode;
        this.operationStatus = operationStatus;
        this.id = ID();
    }

    static int ID()
    {
        return 45;
    }

    @Override
    public String toString()
    {
        return "Операция по счету " + account.getNumber() + date + " типа: \"" + operationCode.getValue() + "\" имеет статус: " + operationStatus.getValue();
    }

    public OperationStatus getOperationStatus() {
        return operationStatus;
    }

}
