package com.shri.general.leet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
743. Network Delay Time

There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

Example 1:

Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
Output: 2

Note:

N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
*/

public class Network_Travel_Time {

    HashMap<Integer, Integer> dist;

    public int networkDelayTime(int[][] times, int N, int K) {

        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] edge : times) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<int[]>());
            }
            graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
        }

        /*
        this may not be required
        code without sort block - 752 ms
        code with sort block - 47 ms
         */
        for (int node : graph.keySet()) {
            Collections.sort(graph.get(node), (a, b) -> a[0] - b[0]);
        }

        dist = new HashMap<>();
        for (int i = 1; i<=N; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }

        depthFirstSearch(graph, K, 0);

        int maxElapsed = 0;
        for (int distance : dist.values()) {
            if (distance == Integer.MAX_VALUE) return -1;
            maxElapsed = Math.max(distance, maxElapsed);
        }

        return maxElapsed;
    }

    private void depthFirstSearch(Map<Integer, List<int[]>> graph, int nodeCurrent, int elapsed) {

        if (elapsed >= dist.get(nodeCurrent)) return;
        dist.put(nodeCurrent, elapsed);

        if (graph.containsKey(nodeCurrent)) {
            for (int[] node : graph.get(nodeCurrent)) {
                depthFirstSearch(graph, node[1], node[0] + elapsed);
            }
        }
    }

    @Test
    public void testScenario1() {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int N = 4;
        int K = 2;
        assertEquals(2, networkDelayTime(times, N, K));
    }
}
