package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _11_Container_With_Most_Water {

    public int maxArea_n2(int[] height) {

        int maxArea = Integer.MIN_VALUE;

        if (height.length < 2) return 0;

        for (int innerLoop = 0; innerLoop < height.length - 1; innerLoop++) {
            for (int outerloop = innerLoop + 1; outerloop < height.length; outerloop++) {
                int tempArea = Math.min(height[innerLoop], height[outerloop]) * (outerloop - innerLoop);
                maxArea = Math.max(maxArea, tempArea);
            }
        }
        return maxArea;
    }

    public int maxArea_n(int[] height) {

        if (height.length < 2) return 0;

        int left = 0, right = height.length - 1;
        int maxArea =  Integer.MIN_VALUE;

        while (left < right) {

            int tempArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, tempArea);

            // Move the pointer at the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    @Test
    void testExampleCase() {
        _11_Container_With_Most_Water solver = new _11_Container_With_Most_Water();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        assertEquals(49, solver.maxArea_n2(height));
        assertEquals(49, solver.maxArea_n(height));
    }

    @Test
    void testSmallArray() {
        _11_Container_With_Most_Water solver = new _11_Container_With_Most_Water();
        int[] height = {1, 1};
        assertEquals(1, solver.maxArea_n2(height));
        assertEquals(1, solver.maxArea_n(height));
    }

    @Test
    void testIncreasingHeights() {
        _11_Container_With_Most_Water solver = new _11_Container_With_Most_Water();
        int[] height = {1, 2, 3, 4, 5};
        assertEquals(6, solver.maxArea_n2(height));
        assertEquals(6, solver.maxArea_n(height));
    }

    @Test
    void testDecreasingHeights() {
        _11_Container_With_Most_Water solver = new _11_Container_With_Most_Water();
        int[] height = {5, 4, 3, 2, 1};
        assertEquals(6, solver.maxArea_n2(height));
        assertEquals(6, solver.maxArea_n(height));
    }

    @Test
    void testSingleElement() {
        _11_Container_With_Most_Water solver = new _11_Container_With_Most_Water();
        int[] height = {5};
        assertEquals(0, solver.maxArea_n2(height));
        assertEquals(0, solver.maxArea_n(height));
    }

    @Test
    void testEmptyArray() {
        _11_Container_With_Most_Water solver = new _11_Container_With_Most_Water();
        int[] height = {};
        assertEquals(0, solver.maxArea_n2(height));
        assertEquals(0, solver.maxArea_n(height));
    }
}