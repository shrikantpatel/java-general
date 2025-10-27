package com.shri.general.leet;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

/*
551. Student Attendance Record I

You are given a string representing an attendance record for a student. The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False
 */
public class Student_Attendence_Record_Test1 {

    public boolean checkRecord(String s) {

        int absent = 0;
        boolean previousLate = false;
        int continuousLate = 0;
        boolean reward = true;


        char[] records = s.toCharArray();
        int i = 0;
        while (reward && i < records.length) {
            char c = records[i++];
            if (c == 'A') absent++;
            if (c == 'L') {
                continuousLate++;
            } else {
                continuousLate = 0;
            }

            if (continuousLate > 2 || absent > 1) reward = false;
        }

        return reward;

    }

    @Test
    public void testCase1() {
        assertTrue(checkRecord("PPALLP"));
    }

    @Test
    public void testCase2() {
        assertFalse(checkRecord("PPALLL"));
    }
}
