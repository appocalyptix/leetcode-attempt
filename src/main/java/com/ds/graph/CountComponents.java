package com.ds.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * #323. Number of Connected Components in an Undirected Graph
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to
 * find the number of connected components in an undirected graph.
 * <p>
 * Example 1:
 * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 * Output: 2
 * <p>
 * Example 2:
 * Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 * Output:  1
 */
public class CountComponents {
    public int countComponents(int n, int[][] edges) {
        if (n == 0) {
            return 0;
        }
        if (edges.length == 0) {
            return n;
        }

        Graph g = new Graph(n);
        for (int i = 0; i < edges.length; i++) {
            g.addEdge(edges[i][0], edges[i][1]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque();
        int counter = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                queue.add(i);
                bst(n, g, visited, queue);
                counter++;
            }
        }
        return counter;
    }

    private void bst(int n, Graph g, boolean[] visited, Queue<Integer> queue) {

        while (!queue.isEmpty()) {
            int v = queue.poll();

            if (visited[v]) {
                continue;
            }
            visited[v] = true;

            if (g.adj[v] != null) {
                for (int i = 0; i < g.adj[v].size(); i++) {
                    queue.add(g.adj[v].get(i));
                }
            }
        }
    }

    static class Graph {
        int vertices;
        List<Integer>[] adj;

        Graph(int vertices) {
            this.vertices = vertices;
            this.adj = new List[vertices];
        }

        public void addEdge(int x, int y) {
            if (adj[x] == null) {
                adj[x] = new ArrayList();
            }
            if (adj[y] == null) {
                adj[y] = new ArrayList();
            }
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    public static void main(String[] args) {
        CountComponents cc = new CountComponents();
        int[][] e = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(cc.countComponents(5, e));
    }
}
