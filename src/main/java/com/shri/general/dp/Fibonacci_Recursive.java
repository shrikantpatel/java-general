package com.shri.general.dp;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Fibonacci_Recursive {

    //recursive way
    public int fib_recursive(int n) {

        if (n <= 1) return n;
        return fib_recursive(n-1) + fib_recursive(n-2);
    }

    //Dynamic programing way
    public int fib_dp(int n) {

        /* Declare an array to store Fibonacci numbers. */
        int[] f = new int[n + 2]; // 1 extra to handle case, n = 0

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;
        f[1] = 1;

        for (int i=2 ; i<=n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    /*
    0, 1, 1, 2, 3, 5, 8,
     */

    @Test
    public void test0() {
        assertEquals(0, fib_recursive(0));
        assertEquals(0, fib_dp(0));
    }

    @Test
    public void test1() {
        assertEquals(1, fib_recursive(1));
        assertEquals(1, fib_dp(1));
    }


    @Test
    public void test2() {
        assertEquals(1, fib_recursive(2));
        assertEquals(1, fib_dp(2));
    }

    @Test
    public void test3() {
        assertEquals(2, fib_recursive(3));
        assertEquals(2, fib_dp(3));
    }

    @Test
    public void test4() {
        assertEquals(3, fib_recursive(4));
        assertEquals(3, fib_dp(4));
    }

    @Test
    public void test5() {
        assertEquals(5, fib_recursive(5));
        assertEquals(5, fib_dp(5));
    }

    @Test
    public void test6() {
       // assertEquals(8, fib_recursive(6));
        assertEquals(8, fib_dp(6));
    }
}
