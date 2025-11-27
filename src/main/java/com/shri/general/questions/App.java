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

        // CREATE_ACCOUNT,account2
        // DEPOSIT,non-existing,2700
        // DEPOSIT,account1,2700

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


class AccountManagement {

    Map<String, Integer> accountDetails = new HashMap<>();

    public boolean createAccount(String accountId) {


        if (accountId != null && !accountDetails.containsKey(accountId)) {
            accountDetails.put(accountId, 0);
            return true;
        }

        return false;
    }

    public int transaction(String accountId, int amount, String transactionType) {

        if (amount < 1) return -1;

        if (accountId != null && accountDetails.containsKey(accountId)) {

            //System.out.println("account - "+ accountId);
            //System.out.println("amount - "+ amount);

            if (("DEPOSIT").equals(transactionType)) {

                int currentBalance = accountDetails.get(accountId);
                currentBalance += amount;
                accountDetails.put(accountId, currentBalance);
                return currentBalance;
            } else if (("WITHDRAW").equals(transactionType)) {

                int currentBalance = accountDetails.get(accountId);
                currentBalance -= amount;
                accountDetails.put(accountId, currentBalance);
                return currentBalance;
            }
        }

        return -1;
    }

    // This should transfer the given amount of money from account with `fromId` to account with `toId`.
    public int transfer(String fromId, String toId, int amount) {

        // - Returns -1 if `fromId` and `toId` are the same.
        if (fromId == null || toId == null || fromId.equals(toId)) return -1;

        // - Returns -1 if `fromId` or `toId` doesn't exist.
        if (!accountDetails.containsKey(fromId)) return -1;
        if (!accountDetails.containsKey(toId)) return -1;

        // - Returns -1 if funds on the account `fromId` are insufficient to perform the transfer.
        int fromBalance = accountDetails.get(fromId);

        if (fromBalance < amount) return -1;

        // - Returns the balance of `fromId` if the transfer was successful, or -1 otherwise.
        transaction(toId, amount, "DEPOSIT");
        return transaction(fromId, amount, "WITHDRAW");


    }
}

