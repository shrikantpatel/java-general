package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/flood-fill/description/
 */
public class _733_Flood_Fill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        return floodFill(image, sr, sc, color, image[sr][sc]);

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color, int originalColor) {

        int colCount = image[0].length;
        int rowCount = image.length;

        if (sr >= rowCount || sr < 0) return image;
        if (sc >= colCount || sc < 0) return image;

        if (image[sr][sc] == color) return image;
        else if (image[sr][sc] == originalColor) {
            image[sr][sc] = color;
            floodFill(image, sr - 1, sc, color, originalColor);
            floodFill(image, sr + 1, sc, color, originalColor);
            floodFill(image, sr, sc + 1, color, originalColor);
            floodFill(image, sr, sc - 1, color, originalColor);
        }
        return image;
    }

    // 🧪 JUnit test method
    @Test
    public void testFloodFill() {
        _733_Flood_Fill filler = new _733_Flood_Fill();
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int[][] expected = {
                {2, 2, 2},
                {2, 2, 0},
                {2, 0, 1}
        };
        int[][] result = filler.floodFill(image, 1, 1, 2);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testNoChangeNeeded() {
        _733_Flood_Fill filler = new _733_Flood_Fill();
        int[][] image = {
                {0, 0},
                {0, 0}
        };
        int[][] expected = {
                {0, 0},
                {0, 0}
        };
        int[][] result = filler.floodFill(image, 0, 0, 0);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSinglePixelFill() {
        _733_Flood_Fill filler = new _733_Flood_Fill();
        int[][] image = {
                {1}
        };
        int[][] expected = {
                {2}
        };
        int[][] result = filler.floodFill(image, 0, 0, 2);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDisconnectedRegion() {
        _733_Flood_Fill filler = new _733_Flood_Fill();
        int[][] image = {
                {1, 1, 0},
                {1, 0, 0},
                {0, 0, 1}
        };
        int[][] expected = {
                {2, 2, 0},
                {2, 0, 0},
                {0, 0, 1}
        };
        int[][] result = filler.floodFill(image, 0, 0, 2);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFillCornerPixel() {
        _733_Flood_Fill filler = new _733_Flood_Fill();
        int[][] image = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int[][] expected = {
                {9, 9, 9},
                {9, 9, 9},
                {9, 9, 9}
        };
        int[][] result = filler.floodFill(image, 0, 0, 9);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testOutOfBoundsStart() {
        _733_Flood_Fill filler = new _733_Flood_Fill();
        int[][] image = {
                {1, 1},
                {1, 1}
        };
        int[][] expected = {
                {1, 1},
                {1, 1}
        };
        int[][] result = filler.floodFill(image, -1, 0, 2); // Invalid start row
        assertArrayEquals(expected, result);
    }


}
