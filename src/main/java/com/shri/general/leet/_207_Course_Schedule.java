package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/course-schedule/description/
 */
public class _207_Course_Schedule {

    /**
     * Determines if all courses can be finished given prerequisites.
     *
     * @param numCourses    total number of courses (labeled 0..numCourses-1)
     * @param prerequisites list of prerequisite pairs [a, b] meaning:
     *                      to take course a, you must first take course b
     * @return true if it's possible to finish all courses (graph is acyclic),
     * false if there is a cycle
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build adjacency list representation of the graph
        // Each course points to the list of courses that depend on it
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>()); // initialize empty list for each course
        }
        for (int[] pre : prerequisites) {
            // pre[1] → pre[0] (to take pre[0], must first take pre[1])
            graph.get(pre[1]).add(pre[0]);
        }

        // Step 2: Track visitation state of each node
        // 0 = unvisited, 1 = visiting (currently in recursion stack), 2 = visited (fully processed)
        int[] state = new int[numCourses];

        // Step 3: Run DFS from each unvisited node to detect cycles
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) { // only start DFS if node hasn't been visited yet
                if (hasCycle(graph, state, i)) {
                    return false; // cycle detected → cannot finish all courses
                }
            }
        }

        // If no cycle found in any DFS traversal, all courses can be finished
        return true;
    }

    /**
     * Helper method to perform DFS and detect cycles.
     *
     * @param graph  adjacency list of the course graph
     * @param state  visitation state array
     * @param course current node being explored
     * @return true if a cycle is detected, false otherwise
     */
    private boolean hasCycle(List<List<Integer>> graph, int[] state, int course) {
        // Mark current node as "visiting"
        state[course] = 1;

        // Explore all neighbors (courses that depend on this one)
        for (int next : graph.get(course)) {
            if (state[next] == 1) {
                // Found a node that is already in "visiting" state → cycle detected
                return true;
            }
            if (state[next] == 0) {
                // If neighbor is unvisited, recursively DFS into it
                if (hasCycle(graph, state, next)) {
                    return true; // propagate cycle detection upward
                }
            }
        }

        // Mark current node as "visited" (fully processed, no cycle found here)
        state[course] = 2;
        return false; // no cycle detected from this path
    }

    @Test
    void testNoPrerequisites() {
        _207_Course_Schedule cs = new _207_Course_Schedule();
        assertTrue(cs.canFinish(3, new int[][]{}));
    }

    @Test
    void testSimpleChain() {
        _207_Course_Schedule cs = new _207_Course_Schedule();
        int[][] prereqs = {{1,0},{2,1},{3,2}};
        assertTrue(cs.canFinish(4, prereqs));
    }

    @Test
    void testSimpleCycle() {
        _207_Course_Schedule cs = new _207_Course_Schedule();
        int[][] prereqs = {{1,0},{0,1}};
        assertFalse(cs.canFinish(2, prereqs));
    }

    @Test
    void testLongerCycle() {
        _207_Course_Schedule cs = new _207_Course_Schedule();
        int[][] prereqs = {{1,0},{2,1},{3,2},{0,3}};
        assertFalse(cs.canFinish(4, prereqs));
    }

    @Test
    void testDisconnectedGraphNoCycle() {
        _207_Course_Schedule cs = new _207_Course_Schedule();
        int[][] prereqs = {{1,0},{3,2}};
        assertTrue(cs.canFinish(4, prereqs));
    }

    @Test
    void testDisconnectedGraphWithCycle() {
        _207_Course_Schedule cs = new _207_Course_Schedule();
        int[][] prereqs = {{1,0},{0,1},{3,2}};
        assertFalse(cs.canFinish(4, prereqs));
    }

    @Test
    void testSingleCourse() {
        _207_Course_Schedule cs = new _207_Course_Schedule();
        assertTrue(cs.canFinish(1, new int[][]{}));
    }

    @Test
    void testTwoCoursesNoCycle() {
        _207_Course_Schedule cs = new _207_Course_Schedule();
        int[][] prereqs = {{1,0}};
        assertTrue(cs.canFinish(2, prereqs));
    }

    @Test
    void testTwoCoursesCycle() {
        _207_Course_Schedule cs = new _207_Course_Schedule();
        int[][] prereqs = {{1,0},{0,1}};
        assertFalse(cs.canFinish(2, prereqs));
    }

    @Test
    void testLargeAcyclicGraph() {
        _207_Course_Schedule cs = new _207_Course_Schedule();
        int[][] prereqs = {
                {1,0},{2,0},{3,1},{4,2},{5,3},{6,4},{7,5},{8,6},{9,7}
        };
        assertTrue(cs.canFinish(10, prereqs));
    }

    @Test
    void testLargeGraphWithCycle() {
        _207_Course_Schedule cs = new _207_Course_Schedule();
        int[][] prereqs = {
                {1,0},{2,0},{3,1},{4,2},{5,3},{6,4},{7,5},{8,6},{9,7},{0,9}
        };
        assertFalse(cs.canFinish(10, prereqs));
    }

}
