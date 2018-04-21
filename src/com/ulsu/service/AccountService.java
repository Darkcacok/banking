package com.ulsu.service;

import com.ulsu.*;
import com.ulsu.repository.OperationHistoryRepository;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AccountService {

    private static final Logger Log = Logger.getLogger(AccountService.class);

    public static ArrayList<OperationHistory> transferFunds(Account accountFrom, Account accountTo, Long amount) throws TransactionException {
        ArrayList<OperationHistory> operationHistory = new ArrayList<OperationHistory>();
            operationHistory.add(0, increaseBalance(accountFrom,amount));
        if(operationHistory.get(0).getOperationStatus() == OperationStatus.SUCCESS)
            operationHistory.add(1, decreaseBalance(accountTo,amount));
        else
            operationHistory.set(1, null);


        return operationHistory;
    }

    public static OperationHistory increaseBalance(Account account, long amount) throws TransactionException {

        try {
            OperationHistory operationHistory = null;
            LocalDateTime date = LocalDateTime.now();

            if (account.withDraw(amount)) {
                operationHistory = new OperationHistory(account, date, OperationCode.PULL, OperationStatus.SUCCESS);
                account.transfer(amount);
            } else {
                operationHistory = new OperationHistory(account, date, OperationCode.PULL, OperationStatus.FAILED);
            }
            return operationHistory;
        }
        catch (Exception e)
        {
            throw new TransactionException(e.getMessage());
        }
    }

    public static OperationHistory decreaseBalance(Account account, long amount) {
        LocalDateTime date = LocalDateTime.now();
        OperationHistory operationHistory;
        operationHistory = new OperationHistory(account, date, OperationCode.PUSH, OperationStatus.SUCCESS);


        return  operationHistory;
    }

    public ArrayList<OperationHistory> getStatement(User user, LocalDateTime startingDate,LocalDateTime endingDate) throws TransactionException {
        try{
            if(user == null || startingDate == null)
                throw  new RuntimeException("error");

            ArrayList<OperationHistory> histories = OperationHistoryRepository.getAll();
            ArrayList<OperationHistory> historyUser = new ArrayList<>();
            if(endingDate == null)
                endingDate = LocalDateTime.now();

            for(int i = 0; i < histories.size(); ++i)
                if(histories.get(i).getAccount().getUser() == user && histories.get(i).getDate().compareTo(startingDate) > 0 && histories.get(i).getDate().compareTo(endingDate) < 0)
                    historyUser.add(histories.get(i));

            return historyUser;
        }
        catch (Exception e)
        {
            throw new TransactionException(e.getMessage());
        }

    }

    public Map<Account, ArrayList<OperationHistory>> getStatement(User user, LocalDateTime startingDate, LocalDateTime endingDate, ArrayList<Integer> number) throws TransactionException {
        try{
            if(user == null || startingDate == null)
                throw  new RuntimeException("error");


            if(endingDate == null)
                endingDate = LocalDateTime.now();

            ArrayList<OperationHistory> histories = OperationHistoryRepository.getAll();
            HashMap<Account, ArrayList<OperationHistory>> map = new HashMap<>();
            ArrayList<OperationHistory> historyUser = new ArrayList<>();
            Account account = null;

            for(int j =  0; j < number.size(); ++j){
                for(int i = 0; i < histories.size(); ++i)
                    if(histories.get(i).getAccount().getNumber() ==  number.get(j)) {
                        if (histories.get(i).getAccount().getUser() == user && histories.get(i).getDate().compareTo(startingDate) > 0 && histories.get(i).getDate().compareTo(endingDate) < 0) {
                            historyUser.add(histories.get(i));
                            account = histories.get(i).getAccount();
                        }
                    }
                if(account!=null) {
                    map.put(account, histories);
                    account = null;
                    histories.clear();
                }
            }
            return map;
        }
        catch (Exception e)
        {
            throw new TransactionException(e.getMessage());
        }

    }
}
