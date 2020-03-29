package com.shri.demo.leet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
A password is considered strong if below conditions are all met:

1. It has at least 6 characters and at most 20 characters.
2. It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
3. It must NOT contain three repeating characters in a row ("...aaa..." is weak,
but "...aa...a..." is strong, assuming other conditions are met).

Write a function strongPasswordChecker(s), that takes a string s as input, and
return the MINIMUM change required to make s a strong password. If s is already strong, return 0.

Insertion, deletion or replace of any one character are all considered as one change.

 */
public class Strong_Password_Checker {


    public int strongPasswordChecker(String s) {

        final int MIN_LENGTH = 6;
        final int MAX_LENGTH = 20;
        final int MAX_LOWER_CASE = 1;
        final int MAX_UPPER_CASE = 1;
        final int MAX_DIGIT = 1;

        int length = s.length();
        int changesRequired = 0;

        int characterToAdd = 0;
        int characterToRemove = 0;
        int characterToChange = 0;
        int characterDuplicate = 0;

        // check for min length
        if (length < MIN_LENGTH) {
            characterToAdd = MIN_LENGTH - length;
        }

        //check max length
        if (length > MAX_LENGTH) {
            characterToRemove = length - MAX_LENGTH;
        }

        // check for upper and lower case and digit
        boolean upperCaseFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        char ch;

        for (
                int i = 0;
                i < length; i++) {
            ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                numberFlag = true;
            } else if (Character.isUpperCase(ch)) {
                upperCaseFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
        }

        if (!upperCaseFlag) characterToChange++;
        if (!lowerCaseFlag) characterToChange++;
        if (!numberFlag) characterToChange++;

        // repeating/duplicate character test
        char ch1;
        char ch2;
        char ch3;

        for (int i = 0; i < length - 2; i++) {
            ch1 = s.charAt(i);
            ch2 = s.charAt(i + 1);
            ch3 = s.charAt(i + 2);

            if ((ch1 == ch2) && (ch2 == ch3) && Character.isLetterOrDigit(ch1)) {
                characterDuplicate++;
                i = i + 2;
            }
        }
        if (characterDuplicate > 6) {
            characterDuplicate = 6;
        }

        System.out.println("length - " + length);
        System.out.println("characterToChange - " + characterToChange);
        System.out.println("characterToRemove - " + characterToRemove);
        System.out.println("characterToAdd - " + characterToAdd);
        System.out.println("characterDuplicate - " + characterDuplicate);

        if (characterToAdd > 3) {
            changesRequired = characterToAdd;
        } else if (characterToAdd <= 3 && characterToAdd > 0) {
            changesRequired = characterToAdd + Math.min(characterToChange, characterDuplicate);
        }

        if (characterToAdd == 0 && characterToRemove == 0) {
            changesRequired = Math.max(characterToChange, characterDuplicate);
        }

        if (characterToRemove > 0) {
            int temp;
            if (characterToRemove >= characterDuplicate) {
                temp = characterToRemove;
            } else {
                temp = characterDuplicate - characterToRemove;
            }
            changesRequired = characterToChange + temp;
        }

        return changesRequired;
    }


    public static void main(String[] args) {

        Strong_Password_Checker s = new Strong_Password_Checker();

        String password = "";
        System.out.println("***********************************************");
        int changeRequired = s.strongPasswordChecker(password);
        System.out.println(password + " changes required - " + changeRequired + "  " + (changeRequired == 6));
        System.out.println("***********************************************");

        System.out.println("***********************************************");
        password = "a";
        changeRequired = s.strongPasswordChecker(password);
        System.out.println(password + " changes required - " + changeRequired + "  " + (changeRequired == 5));
        System.out.println("***********************************************");

        System.out.println("***********************************************");
        password = "aA1";
        changeRequired = s.strongPasswordChecker(password);
        System.out.println(password + " changes required - " + changeRequired + "  " + (changeRequired == 3));
        System.out.println("***********************************************");

        System.out.println("***********************************************");
        password = "aaa123";
        changeRequired = s.strongPasswordChecker(password);
        System.out.println(password + " changes required - " + changeRequired + "  " + (changeRequired == 1));
        System.out.println("***********************************************");

        System.out.println("***********************************************");
        password = "aaa111";
        changeRequired = s.strongPasswordChecker(password);
        System.out.println(password + " changes required - " + changeRequired + "  " + (changeRequired == 2));
        System.out.println("***********************************************");

        System.out.println("***********************************************");
        password = "1111111111";
        changeRequired = s.strongPasswordChecker(password);
        System.out.println(password + " changes required - " + changeRequired + "  " + (changeRequired == 3));
        System.out.println("***********************************************");

        System.out.println("***********************************************");
        password = "ABABABABABABABABABAB1";
        changeRequired = s.strongPasswordChecker(password);
        System.out.println(password + " changes required - " + changeRequired + "  " + (changeRequired == 2));
        System.out.println("***********************************************");

        System.out.println("***********************************************");
        password = "abababababababababaaa";
        changeRequired = s.strongPasswordChecker(password);
        System.out.println(password + " changes required - " + changeRequired + "  " + (changeRequired == 3));
        System.out.println("***********************************************");

        System.out.println("***********************************************");
        password = "aaaaaaaaaaaaaaaaaaaaa";
        changeRequired = s.strongPasswordChecker(password);
        System.out.println(password + " changes required - " + changeRequired + "  " + (changeRequired == 7));
        System.out.println("***********************************************");

        System.out.println("***********************************************");
        password = "1010101010aaaB10101010";
        changeRequired = s.strongPasswordChecker(password);
        System.out.println(password + " changes required - " + changeRequired + "  " + (changeRequired == 2));
        System.out.println("***********************************************");

        System.out.println("***********************************************");
        password = "...";
        changeRequired = s.strongPasswordChecker(password);
        System.out.println(password + " changes required - " + changeRequired + "  " + (changeRequired == 3));
        System.out.println("***********************************************");

        System.out.println("***********************************************");
        password = "1234567890123456Baaaaa";
        changeRequired = s.strongPasswordChecker(password);
        System.out.println(password + " changes required - " + changeRequired + "  " + (changeRequired == 3));
        System.out.println("***********************************************");

    }
}