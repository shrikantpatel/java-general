package com.shri.general.leet;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/accounts-merge/
 */
public class _721_Accounts_Merge_Edge_NotWorking {

    private static class Account {
        String userName;
        SortedSet<String> emailSet = new TreeSet<>(); // keeps emails sorted
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        // Maps each email → Account object
        // Multiple emails may point to the same Account instance
        HashMap<String, Account> emailToUser = new HashMap<>();

        // Tracks all emails seen so far
        Set<String> emailMasterSet = new HashSet<>();

        for (List<String> account : accounts) {

            String userName = account.get(0);

            // Collect all emails in this account
            Set<String> emails = new HashSet<>();

            // This will hold the Account object we should merge into
            Account accountExist = null;

            // ---------------------------------------------------------
            // STEP 1: Scan all emails in the current account
            // ---------------------------------------------------------
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emails.add(email);

                // If we've seen this email before, retrieve the existing Account object
                if (emailMasterSet.contains(email)) {
                    accountExist = emailToUser.get(email);
                }

                // Mark email as seen
                emailMasterSet.add(email);
            }

            // ---------------------------------------------------------
            // STEP 2: If no existing account found, create a new one
            // ---------------------------------------------------------
            if (accountExist == null) {
                accountExist = new Account();
                accountExist.userName = userName;
            }

            // Add all emails from this account into the chosen Account object
            accountExist.emailSet.addAll(emails);

            // ---------------------------------------------------------
            // STEP 3: Point ALL emails in this account to the same Account object
            // ---------------------------------------------------------
            Account finalAccountExist = accountExist;

            // This is the key behavior:
            // Every email in this account now maps to the SAME Account instance.
            // If two accounts share an email, they will share the same Account object.
            emails.forEach(s -> emailToUser.put(s, finalAccountExist));
        }

        // ---------------------------------------------------------
        // STEP 4: Build final result
        // ---------------------------------------------------------
        List<List<String>> result = new ArrayList<>();

        // emailToUser.values() may contain many duplicate references
        // .distinct() keeps only unique Account objects
        emailToUser.values().stream().distinct().forEach(c -> {
                    List<String> account = new ArrayList<>();
                    account.add(c.userName);
                    account.addAll(c.emailSet); // already sorted
                    result.add(account);
                }
        );

        return result;
    }

    private void sortOuterList(List<List<String>> list) {
        list.sort(Comparator.comparing(a -> a.get(1))); // sort by first email
    }


    @Test
    void testExample1() {
        _721_Accounts_Merge_Edge_NotWorking m = new _721_Accounts_Merge_Edge_NotWorking();

        List<List<String>> input = List.of(
                List.of("John", "a@mail", "b@mail"),
                List.of("John", "b@mail", "c@mail"),
                List.of("John", "d@mail"),
                List.of("John", "o@mail", "p@mail")
        );

        List<List<String>> expected = new ArrayList<>(List.of(
                List.of("John", "a@mail", "b@mail", "c@mail"),
                List.of("John", "d@mail"),
                List.of("John", "o@mail", "p@mail")
        ));

        List<List<String>> actual = m.accountsMerge(input);

        sortOuterList(expected);
        sortOuterList(actual);

        assertEquals(expected, actual);
    }


    @Test
    void testSingleAccount() {
        _721_Accounts_Merge_Edge_NotWorking m = new _721_Accounts_Merge_Edge_NotWorking();

        List<List<String>> input = List.of(
                List.of("Mary", "x@mail", "y@mail")
        );

        List<List<String>> expected = List.of(
                List.of("Mary", "x@mail", "y@mail")
        );

        assertEquals(expected, m.accountsMerge(input));
    }

    @Test
    void testNoOverlap() {
        _721_Accounts_Merge_Edge_NotWorking m = new _721_Accounts_Merge_Edge_NotWorking();

        List<List<String>> input = List.of(
                List.of("A", "a@mail"),
                List.of("B", "b@mail"),
                List.of("C", "c@mail")
        );

        List<List<String>> expected = new ArrayList<>(List.of(
                List.of("A", "a@mail"),
                List.of("B", "b@mail"),
                List.of("C", "c@mail")
        ));

        List<List<String>> actual = m.accountsMerge(input);

        // Sort both lists before comparing
        sortOuterList(expected);
        sortOuterList(actual);

        assertEquals(expected, actual);
    }

    @Test
    void testFullChainMerge() {
        _721_Accounts_Merge_Edge_NotWorking m = new _721_Accounts_Merge_Edge_NotWorking();

        List<List<String>> input = List.of(
                List.of("John", "a@mail", "b@mail"),
                List.of("John", "b@mail", "c@mail"),
                List.of("John", "c@mail", "d@mail")
        );

        List<List<String>> expected = List.of(
                List.of("John", "a@mail", "b@mail", "c@mail", "d@mail")
        );

        assertEquals(expected, m.accountsMerge(input));
    }

    @Test
    void testEmptyInput() {
        _721_Accounts_Merge_Edge_NotWorking m = new _721_Accounts_Merge_Edge_NotWorking();

        List<List<String>> input = List.of();
        List<List<String>> expected = List.of();

        assertEquals(expected, m.accountsMerge(input));
    }

    @Test
    void testDavidCaseFullyMerged() {
        _721_Accounts_Merge_Edge_NotWorking m = new _721_Accounts_Merge_Edge_NotWorking();

        List<List<String>> input = List.of(
                List.of("David", "David0@m.co", "David1@m.co"),
                List.of("David", "David3@m.co", "David4@m.co"),
                List.of("David", "David4@m.co", "David5@m.co"),
                List.of("David", "David2@m.co", "David3@m.co"),
                List.of("David", "David1@m.co", "David2@m.co")
        );

        List<List<String>> expected = List.of(
                List.of(
                        "David",
                        "David0@m.co",
                        "David1@m.co",
                        "David2@m.co",
                        "David3@m.co",
                        "David4@m.co",
                        "David5@m.co"
                )
        );

        assertEquals(expected, m.accountsMerge(input));
    }

}