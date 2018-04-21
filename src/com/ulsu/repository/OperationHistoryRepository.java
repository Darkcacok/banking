package com.ulsu.repository;

import com.ulsu.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import static com.ulsu.service.AccountService.transferFunds;

public class OperationHistoryRepository {

    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Account> accounts = new ArrayList<>();
    static ArrayList<OperationHistory> histories = new ArrayList<>();

    static{
        users.add(new User("firstName", "firstSurname", "phone1", "email1", 25));
        users.add(new User("secondName", "secondSurname", "phone2", "email2", 26));
        accounts.add(new Account(1, users.get(0),500));
        accounts.add(new Account(2, users.get(1),300));
        accounts.add(new Account(3,users.get(1),400));

        LocalDateTime date = LocalDateTime.now();

        histories.add(new OperationHistory(accounts.get(0), date.minusDays(5), OperationCode.PULL, OperationStatus.SUCCESS));
        histories.add(new OperationHistory(accounts.get(1), date.minusDays(2), OperationCode.PULL, OperationStatus.SUCCESS));
        histories.add(new OperationHistory(accounts.get(2), date.minusDays(3), OperationCode.PULL, OperationStatus.SUCCESS));

    }

    public static ArrayList<OperationHistory> getAll()
    {



        return histories;
    }
}
