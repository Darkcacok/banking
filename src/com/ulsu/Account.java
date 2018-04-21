package com.ulsu;

public class Account{
    AccountStatus status;
    User user;
    int number;
    double balance;


    public Account(int number, User user, double balance){
        this.number = number;
        this.user = user;
        this.status = AccountStatus.ACTIVE;
        this.balance = balance;
    }
    public void setBalance(float money){
        this.balance = money;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public boolean withDraw(float money)
    {
        if(status == AccountStatus.LOCKED)
            return false;
        if (balance - money < 0)
            return false;
        else
        {
            this.balance -=money;
            return true;
        }
    }

    public boolean transfer(float money){
        if(status == AccountStatus.LOCKED)
            return false;
        this.balance+=money;
        return true;
    }

    public int getNumber() {
        return this.number;
    }


    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}