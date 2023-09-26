package com.shri.general.leet;

import org.junit.Assert;
import org.junit.Test;

/**
 * 605. Can Place Flowers
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 * <p>
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
 * <p>
 * Example 1:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] is 0 or 1.
 * There are no two adjacent flowers in flowerbed.
 * 0 <= n <= flowerbed.length
 **/
public class Can_Place_Flowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int len = flowerbed.length;
        int canBePlanted = 0;
        int previousPlot = 0;
        int nextPlot = 0;

        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                nextPlot = 0;
            } else {
                nextPlot = flowerbed[i + 1];
            }
            if (previousPlot == 0 && flowerbed[i] == 0 && nextPlot == 0) {
                canBePlanted++;
                flowerbed[i] = 1;
            }
            previousPlot = flowerbed[i];
        }

        return canBePlanted >= n;
    }

    @Test
    public void testScenario1() {
        Can_Place_Flowers s = new Can_Place_Flowers();
        Assert.assertTrue(s.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
    }

    @Test
    public void testScenario2() {
        Can_Place_Flowers s = new Can_Place_Flowers();
        Assert.assertFalse(s.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    }

    @Test
    public void testScenario3() {
        Can_Place_Flowers s = new Can_Place_Flowers();
        Assert.assertFalse(s.canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
    }

    @Test
    public void testScenario4() {
        Can_Place_Flowers s = new Can_Place_Flowers();
        Assert.assertTrue(s.canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
    }

    @Test
    public void testScenario5() {
        Can_Place_Flowers s = new Can_Place_Flowers();
        Assert.assertTrue(s.canPlaceFlowers(new int[]{0}, 1));
    }
}
