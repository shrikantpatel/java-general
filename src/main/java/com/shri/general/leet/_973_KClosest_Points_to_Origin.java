package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/description/
 */
public class _973_KClosest_Points_to_Origin {

    public int[][] kClosest(int[][] points, int k) {

            Map<Integer, List<int[]>> distanceMap = new HashMap<>();
            SortedSet<Integer> distanceSet = new TreeSet<>();

            // calculate all the distance of the point from (0,0), add distance to sorted set.
            // map store the distance as key and point as the values.
            for (int[] point : points) {
                int distance = point[0]*point[0] + point[1]*point[1];
                distanceMap.computeIfAbsent(distance, d -> new ArrayList<>()).add(point);
                distanceSet.add(distance);
            }

            int[][] output = new int[k][2];
            int counter = 0;

            // iterate though the set starting with close distance.
            while (counter < k) {
                int distance = distanceSet.removeFirst();

                // for each distance get all the point at this distance from (0,0)
                for (int[] p : distanceMap.get(distance)) {
                    if (counter == k) break;
                    output[counter++] = p;
                }
            }

            return output;
    }

    public int[][] kClosest_MaxHeap(int[][] points, int k) {

        // Max-heap: store {distance, x, y}
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> b[0] - a[0]   // sort by distance descending
        );

        for (int[] p : points) {
            int dist = p[0] * p[0] + p[1] * p[1];

            // Push {distance, x, y}
            maxHeap.offer(new int[]{dist, p[0], p[1]});

            // If heap grows beyond k, remove the farthest point
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Extract k closest points
        int[][] result = new int[k][2];
        int idx = 0;

        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            result[idx++] = new int[]{top[1], top[2]};
        }

        return result;
    }


    private boolean containsPoint(int[][] result, int[] target) {
        for (int[] p : result) {
            if (p[0] == target[0] && p[1] == target[1]) return true;
        }
        return false;
    }

    @Test
    void testSimpleCase() {
        _973_KClosest_Points_to_Origin solver = new _973_KClosest_Points_to_Origin();
        int[][] points = {{1,3},{-2,2}};
        int[][] result = solver.kClosest(points, 1);

        assertEquals(1, result.length);
        assertTrue(containsPoint(result, new int[]{-2,2}));
    }

    @Test
    void testTwoClosest() {
        _973_KClosest_Points_to_Origin solver = new _973_KClosest_Points_to_Origin();
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int[][] result = solver.kClosest(points, 2);

        assertEquals(2, result.length);
        assertTrue(containsPoint(result, new int[]{3,3}));
        assertTrue(containsPoint(result, new int[]{-2,4}));
    }

    @Test
    void testNegativeCoordinates() {
        _973_KClosest_Points_to_Origin solver = new _973_KClosest_Points_to_Origin();
        int[][] points = {{-5,-4},{2,3},{-1,-1}};
        int[][] result = solver.kClosest(points, 1);

        assertEquals(1, result.length);
        assertTrue(containsPoint(result, new int[]{-1,-1}));
    }

    @Test
    void testKEqualsN() {
        _973_KClosest_Points_to_Origin solver = new _973_KClosest_Points_to_Origin();
        int[][] points = {{1,2},{3,4},{-1,-6}};
        int[][] result = solver.kClosest(points, 3);

        assertEquals(3, result.length);
        assertTrue(containsPoint(result, new int[]{1,2}));
        assertTrue(containsPoint(result, new int[]{3,4}));
        assertTrue(containsPoint(result, new int[]{-1,-6}));
    }

    @Test
    void testDuplicatePoints() {
        _973_KClosest_Points_to_Origin solver = new _973_KClosest_Points_to_Origin();
        int[][] points = {{1,1},{1,1},{2,2}};
        int[][] result = solver.kClosest(points, 2);

        assertEquals(2, result.length);
        assertTrue(containsPoint(result, new int[]{1,1}));
    }

    @Test
    void testLargeValues() {
        _973_KClosest_Points_to_Origin solver = new _973_KClosest_Points_to_Origin();
        int[][] points = {{10000,10000},{1,1},{2,2}};
        int[][] result = solver.kClosest(points, 2);

        assertEquals(2, result.length);
        assertTrue(containsPoint(result, new int[]{1,1}));
        assertTrue(containsPoint(result, new int[]{2,2}));
    }

    @Test
    void testPointsWithSameDistance() {
        _973_KClosest_Points_to_Origin solver = new _973_KClosest_Points_to_Origin();
        int[][] points = {{1,1},{-1,-1},{1,-1},{-1,1}};
        int[][] result = solver.kClosest(points, 4);

        assertEquals(4, result.length);
        // All have distance sqrt(2), any two are valid
        assertTrue(result.length == 4);
    }

    @Test
    void testSinglePoint() {
        _973_KClosest_Points_to_Origin solver = new _973_KClosest_Points_to_Origin();
        int[][] points = {{7,7}};
        int[][] result = solver.kClosest(points, 1);

        assertEquals(1, result.length);
        assertTrue(containsPoint(result, new int[]{7,7}));
    }

    @Test
    void testZeroDistancePoint() {
        _973_KClosest_Points_to_Origin solver = new _973_KClosest_Points_to_Origin();
        int[][] points = {{0,0},{5,5},{3,4}};
        int[][] result = solver.kClosest(points, 1);

        assertEquals(1, result.length);
        assertTrue(containsPoint(result, new int[]{0,0}));
    }

    @Test
    void test_2PointAtSameDistance() {
        _973_KClosest_Points_to_Origin solver = new _973_KClosest_Points_to_Origin();
        int[][] points = { {0,1}, {1,0} };
        int[][] result = solver.kClosest(points, 2);

        assertEquals(2, result.length);
        assertTrue(containsPoint(result, new int[]{0,1}));
        assertTrue(containsPoint(result, new int[]{1,0}));
    }

    // ---------------------------
    // TESTS FOR MAX HEAP VERSION
    // ---------------------------

    @Test
    void testSimpleCase_MaxHeap() {
        _973_KClosest_Points_to_Origin solver = new _973_KClosest_Points_to_Origin();
        int[][] points = {{1,3},{-2,2}};
        int[][] result = solver.kClosest_MaxHeap(points, 1);

        assertEquals(1, result.length);
        assertTrue(containsPoint(result, new int[]{-2,2}));
    }

    @Test
    void testTwoClosest_MaxHeap() {
        _973_KClosest_Points_to_Origin solver = new _973_KClosest_Points_to_Origin();
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int[][] result = solver.kClosest_MaxHeap(points, 2);

        assertEquals(2, result.length);
        assertTrue(containsPoint(result, new int[]{3,3}));
        assertTrue(containsPoint(result, new int[]{-2,4}));
    }

    @Test
    void testNegativeCoordinates_MaxHeap() {
        _973_KClosest_Points_to_Origin solver = new _973_KClosest_Points_to_Origin();
        int[][] points = {{-5,-4},{2,3},{-1,-1}};
        int[][] result = solver.kClosest_MaxHeap(points, 1);

        assertEquals(1, result.length);
        assertTrue(containsPoint(result, new int[]{-1,-1}));
    }

    @Test
    void testKEqualsN_MaxHeap() {
        _973_KClosest_Points_to_Origin solver = new _973_KClosest_Points_to_Origin();
        int[][] points = {{1,2},{3,4},{-1,-6}};
        int[][] result = solver.kClosest_MaxHeap(points, 3);

        assertEquals(3, result.length);
        assertTrue(containsPoint(result, new int[]{1,2}));
        assertTrue(containsPoint(result, new int[]{3,4}));
        assertTrue(containsPoint(result, new int[]{-1,-6}));
    }

    @Test
    void testDuplicatePoints_MaxHeap() {
        _973_KClosest_Points_to_Origin solver = new _973_KClosest_Points_to_Origin();
        int[][] points = {{1,1},{1,1},{2,2}};
        int[][] result = solver.kClosest_MaxHeap(points, 2);

        assertEquals(2, result.length);
        assertTrue(containsPoint(result, new int[]{1,1}));
    }

    @Test
    void testLargeValues_MaxHeap() {
        _973_KClosest_Points_to_Origin solver = new _973_KClosest_Points_to_Origin();
        int[][] points = {{10000,10000},{1,1},{2,2}};
        int[][] result = solver.kClosest_MaxHeap(points, 2);

        assertEquals(2, result.length);
        assertTrue(containsPoint(result, new int[]{1,1}));
        assertTrue(containsPoint(result, new int[]{2,2}));
    }

    @Test
    void testPointsWithSameDistance_MaxHeap() {
        _973_KClosest_Points_to_Origin solver = new _973_KClosest_Points_to_Origin();
        int[][] points = {{1,1},{-1,-1},{1,-1},{-1,1}};
        int[][] result = solver.kClosest_MaxHeap(points, 4);

        assertEquals(4, result.length);
        assertTrue(result.length == 4);
    }

    @Test
    void testSinglePoint_MaxHeap() {
        _973_KClosest_Points_to_Origin solver = new _973_KClosest_Points_to_Origin();
        int[][] points = {{7,7}};
        int[][] result = solver.kClosest_MaxHeap(points, 1);

        assertEquals(1, result.length);
        assertTrue(containsPoint(result, new int[]{7,7}));
    }

    @Test
    void testZeroDistancePoint_MaxHeap() {
        _973_KClosest_Points_to_Origin solver = new _973_KClosest_Points_to_Origin();
        int[][] points = {{0,0},{5,5},{3,4}};
        int[][] result = solver.kClosest_MaxHeap(points, 1);

        assertEquals(1, result.length);
        assertTrue(containsPoint(result, new int[]{0,0}));
    }

    @Test
    void test_2PointAtSameDistance_MaxHeap() {
        _973_KClosest_Points_to_Origin solver = new _973_KClosest_Points_to_Origin();
        int[][] points = { {0,1}, {1,0} };
        int[][] result = solver.kClosest_MaxHeap(points, 2);

        assertEquals(2, result.length);
        assertTrue(containsPoint(result, new int[]{0,1}));
        assertTrue(containsPoint(result, new int[]{1,0}));
    }

}