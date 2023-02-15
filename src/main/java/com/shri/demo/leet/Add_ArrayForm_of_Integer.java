package com.shri.demo.leet;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
/**
 * 989. Add to Array-Form of Integer

 * The array-form of an integer num is an array representing its digits in left to right order.
 *
 * For example, for num = 1321, the array form is [1,3,2,1].
 * Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
 *
 * Example 1:
 *
 * Input: num = [1,2,0,0], k = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 * Example 2:
 *
 * Input: num = [2,7,4], k = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 * Example 3:
 *
 * Input: num = [2,1,5], k = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 *
 * Constraints:
 *
 * 1 <= num.length <= 104
 * 0 <= num[i] <= 9
 * num does not contain any leading zeros except for the zero itself.
 * 1 <= k <= 104

 */
public class Add_ArrayForm_of_Integer {

    public List<Integer> addToArrayForm(int[] num, int k) {

        String firstNum = "";
        for (int i = 0; i < num.length; i++) {
            firstNum = firstNum + num[i];
        }
        BigInteger first = new BigInteger(firstNum);
        BigInteger second = new BigInteger(String.valueOf(k));
        first = first.add(second);

        String total = first.toString();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < total.length(); i++) {
            answer.add(total.charAt(i)-'0');
        }
        return answer;

    }

    @Test
    public void test1() {
        Add_ArrayForm_of_Integer sol = new Add_ArrayForm_of_Integer();
        int[] expected = {1, 2, 3, 4};
        List<Integer> actual = sol.addToArrayForm(new int[]{1, 2, 0, 0}, 34);
        Assert.assertArrayEquals(expected, actual.stream().mapToInt(i -> i).toArray());
    }

    @Test
    public void test2() {
        Add_ArrayForm_of_Integer sol = new Add_ArrayForm_of_Integer();
        int[] expected = {4, 5, 5};
        List<Integer> actual = sol.addToArrayForm(new int[]{2, 7, 4}, 181);
        Assert.assertArrayEquals(expected, actual.stream().mapToInt(i -> i).toArray());
    }

    @Test
    public void test3() {
        Add_ArrayForm_of_Integer sol = new Add_ArrayForm_of_Integer();
        int[] expected = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        List<Integer> actual = sol.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1);
        Assert.assertArrayEquals(expected, actual.stream().mapToInt(i -> i).toArray());
    }
}