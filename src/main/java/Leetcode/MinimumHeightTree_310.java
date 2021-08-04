package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumHeightTree_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // adjList
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        // adjList add edges
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // leafNodes
        List<Integer> leafNodes = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> e : adjList.entrySet()) {
            if (e.getValue().size() == 1) {
                leafNodes.add(e.getKey());
            }
        }

        while (n > 2) {
            n -= leafNodes.size();
            // find each leaf node in the graph, and remove them. Also remove them from their                   // neighbors
            for (Integer leaf : leafNodes) {
                Integer leafNeighbor = adjList.get(leaf).iterator().next();

                adjList.get(leafNeighbor).remove(leaf);
                adjList.remove(leaf);
            }

            // find new leaf
            leafNodes = new ArrayList<>();

            for (Map.Entry<Integer, List<Integer>> e : adjList.entrySet()) {
                if (e.getValue().size() == 1) {
                    leafNodes.add(e.getKey());
                }
            }
        }

        return new ArrayList<>(adjList.keySet());
    }
}
