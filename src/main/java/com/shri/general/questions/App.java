package com.shri.general.questions;

import java.util.*;

public class App {
    public static void main(String[] args) {

        List<List<String>> commList = new ArrayList<>();
        commList.add(Arrays.asList("CREATE_ACCOUNT", "account1"));
        commList.add(Arrays.asList("CREATE_ACCOUNT", "account1"));
        commList.add(Arrays.asList("CREATE_ACCOUNT", "account2"));
        commList.add(Arrays.asList("DEPOSIT", "existing", "2700"));
        commList.add(Arrays.asList("DEPOSIT", "account1", "2700"));
        commList.add(Arrays.asList("TRANSFER", "account1", "account2", "2701"));
        commList.add(Arrays.asList("TRANSFER", "account1", "account2", "200"));

        AccountManagement mgmt = new AccountManagement();

        for (List<String> command : commList) {
            switch (command.get(0)) {
                case "CREATE_ACCOUNT":
                    System.out.println(mgmt.createAccount(command.get(1)));
                    break;
                case "DEPOSIT":
                    System.out.println(mgmt.transaction(command.get(1), Integer.parseInt(command.get(2)), "DEPOSIT"));
                    break;
                case "TRANSFER":
                    System.out.println(mgmt.transfer(command.get(1), command.get(2), Integer.parseInt(command.get(3))));
                    break;
            }
        }
    }
}

/**
 * Represents a bank account with an ID and balance.
 */
class Account {
    private final String accountId;
    private int balance;

    public Account(String accountId) {
        this.accountId = accountId;
        this.balance = 0;
    }

    public String getAccountId() {
        return accountId;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public boolean withdraw(int amount) {
        if (amount > balance) return false;
        balance -= amount;
        return true;
    }
}

/**
 * Manages accounts and operations like create, deposit, withdraw, transfer.
 */
class AccountManagement {
    private final Map<String, Account> accounts = new HashMap<>();

    public boolean createAccount(String accountId) {
        if (accountId != null && !accounts.containsKey(accountId)) {
            accounts.put(accountId, new Account(accountId));
            return true;
        }
        return false;
    }

    public int transaction(String accountId, int amount, String transactionType) {
        if (amount < 1) return -1;

        Account account = accounts.get(accountId);
        if (account == null) return -1;

        return switch (transactionType) {
            case "DEPOSIT" -> {
                account.deposit(amount);
                yield account.getBalance();
            }
            case "WITHDRAW" -> {
                if (account.withdraw(amount)) {
                    yield account.getBalance();
                }
                yield -1;
            }
            default -> -1;
        };
    }

    public int transfer(String fromId, String toId, int amount) {
        if (fromId == null || toId == null || fromId.equals(toId)) return -1;

        Account fromAccount = accounts.get(fromId);
        Account toAccount = accounts.get(toId);

        if (fromAccount == null || toAccount == null) return -1;
        if (fromAccount.getBalance() < amount) return -1;

        // Perform transfer
        if (fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            return fromAccount.getBalance();
        }
        return -1;
    }
}