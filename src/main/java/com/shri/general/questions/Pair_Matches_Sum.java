package com.shri.general.questions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Pair_Matches_Sum {

    public boolean solution(int[] list, int sum) {
        Set<Integer> listOfComplement = new HashSet<Integer>();
        for (int i : list) {
            int complement = sum - i;
            if (listOfComplement.contains(i)) {
                return true;
            } else {
                listOfComplement.add(sum - i);
            }
        }
        return false;
    }

    @Test
    public void test1() {
        Pair_Matches_Sum t1 = new Pair_Matches_Sum();
        assertEquals(Boolean.TRUE, t1.solution(new int[]{1, 2, 3, 4, 4}, 8));
    }

    @Test
    public void test2() {
        Pair_Matches_Sum t1 = new Pair_Matches_Sum();
        assertEquals(Boolean.TRUE, t1.solution(new int[]{1, 2, 3, 4, 5}, 8));
    }

    @Test
    public void test3() {
        Pair_Matches_Sum t1 = new Pair_Matches_Sum();
        assertEquals(Boolean.TRUE, t1.solution(new int[]{2, 7, 3, 4, 1}, 3));
    }

    @Test
    public void test4() {
        Pair_Matches_Sum t1 = new Pair_Matches_Sum();
        assertEquals(Boolean.FALSE, t1.solution(new int[]{1, 2, 3, 4, 5}, 10));
    }

    @Test
    public void test5() {
        Pair_Matches_Sum t1 = new Pair_Matches_Sum();
        assertEquals(Boolean.FALSE, t1.solution(new int[]{5, 2, 3, 4, 1}, 0));
    }

    @Test
    public void test6() {
        Pair_Matches_Sum t1 = new Pair_Matches_Sum();
        assertEquals(Boolean.TRUE, t1.solution(new int[]{1, 2, 3, 4, 5}, 9));
    }
}
