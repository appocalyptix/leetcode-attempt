package com.ds.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 785. Is Graph Bipartite
 * <p>
 * Given an undirected graph, return true if and only if it is bipartite.
 * <p>
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.
 * <p>
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
 * <p>
 * Example 1:
 * Input: [[1,3], [0,2], [1,3], [0,2]]
 * Output: true
 * Explanation:
 * The graph looks like this:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * Example 2:
 * Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * Output: false
 * Explanation:
 * The graph looks like this:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * We cannot find a way to divide the set of nodes into two independent subsets.
 */
public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {

        Set<Integer> rSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];


        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                queue.add(i);
                rSet.add(i);
                if (!isPipartiteConnected(graph, queue, visited, rSet, ySet)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isPipartiteConnected(int[][] graph, Queue<Integer> queue, boolean[] visited, Set<Integer> rSet, Set<Integer> ySet) {
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (visited[v]) {
                continue;
            }

            visited[v] = true;
            for (Integer i : graph[v]) {
                queue.add(i);

                if (rSet.contains(v)) {
                    ySet.add(i);
                } else {
                    rSet.add(i);
                }
                if (rSet.contains(i) && ySet.contains(i)) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        BipartiteGraph bg = new BipartiteGraph();
        int[][] i = {{}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {1, 2, 8, 9}, {6, 9}, {1, 5, 7, 8, 9}, {3, 6, 9}, {2, 3, 4, 6, 9}, {2, 4, 5, 6, 7, 8}};
        System.out.println(bg.isBipartite(i));
    }
}
