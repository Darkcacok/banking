package com.ulsu;

import java.util.ArrayList;

import static com.ulsu.service.AccountService.transferFunds;

public class Application {

    /** Задание:
     *
    -- Первая часть: создание классов com.ulsu.User, Operation, com.ulsu.OperationHistory, com.ulsu.Account, енамов.

     1. Написать класс пользователя (com.ulsu.User). У пользователя есть имя, фамилия, номер телефона, емейл и возраст.
        Примечание: у всех классов должен соблюдаться принцип инкапсуляции.
     2. Написать класс Аккаунт (com.ulsu.Account). У аккаунта есть статус, владелец (пользователь), номер и текущий баланс.
     3. Написать класс История операции (com.ulsu.OperationHistory). В истории сохраняется аккаунт, связанный с операцией, дата,
        идентификатор (id), выполняемая операция (com.ulsu.OperationCode), статус операции.

     4. Написать конструкторы в классе com.ulsu.User и com.ulsu.Account.

     5. Написать классы статусов аккаунтов (com.ulsu.AccountStatus), операций (com.ulsu.OperationStatus), а так же коды операций (com.ulsu.OperationCode).
     Они должны быть классами-перечислениями со следующими значениями:

     Статусы аккаунта:

     ACTIVE("Активный"),
     LOCKED("Заблокирован");

     Статусы операций:

     PENDING("В процессе"),
     SUCCESS("Успешно"),
     FAILED("Отклонено");

     Коды операций:
     PULL("Поступление денег"),
     PUSH("Передача денег"),
     CHECK_BALANCE("Получение баланса");

     Перечисления разместить в пакете common в проекте.

    -- Вторая часть:

    1) Реализовать метод transferFunds(com.ulsu.Account accountFrom, com.ulsu.Account accountTo, Long amount),переводящий заданное
        кол-во денег с одного счета на другой (если возможно) и возвращающий соответствующий массив операций.
    2) В методе main написать алгоритм, имитирующий процесс перевода денег с 1 счета на другой (реализовать методы transferFunds(),
        increaseBalance(com.ulsu.Account account, long amount) и decreaseBalance(com.ulsu.Account account, long amount)).
    3) Добавить в конце работы программы вывод данных об истории операций, список которых возвращает метод transferFunds -
        для этого переопределить метод toString() у класса com.ulsu.OperationHistory.

     Примеры вывода:
     пример 1:
     Операция по счету 1 от 2018-01-29T16:06:58.835 типа: "Передача денег" имеет статус: Успешно
     Операция по счету 2 от 2018-01-29T16:06:58.836 типа: "Поступление денег" имеет статус: Успешно

     пример 2:
     Операция по счету 1 от 2018-01-29T16:06:38.197 типа: "Передача денег" имеет статус: Отклонено

    4)* Доп. задание: реализовать метод getBalance(com.ulsu.Account account) возвращающий операцию получения баланса.

    5)* Доп. задание: добавить логику проверок на статус счета (с заблокированным счетом операции невозможны)


     */

    public static void main(String[] args) {
        User firstUser = new User("firstName", "firstSurname", "phone1", "email1", 25);
        User secondUser = new User("secondName", "secondSurname", "phone2", "email2", 26);
        try {

        } (Exception e) {

        }
        Account firstAccount = new Account(1, firstUser, 2000);
        Account secondAccount = new Account(2, secondUser, 1000);
//        firstAccount.setBalance(500);

        ArrayList<OperationHistory> operationHistories = transferFunds(firstAccount, secondAccount, 500L);

        for (OperationHistory operationHistory: operationHistories) {
            if (operationHistory != null) {
                System.out.println(operationHistory);
            }
        }

    }

}
