package com.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class ValidTree {
    public boolean validTree(int n, int[][] edges) {

        if (n == 0) {
            return true;
        }

        if (edges.length == 0 && n > 1) {
            return false;
        }

        Graph g = new Graph(n);

        for (int i = 0; i < edges.length; i++) {
            g.addEdge(edges[i][0], edges[i][1]);
        }

        boolean[] visited = new boolean[n];
        boolean hasCycle = hasCycle(g, 0, visited, -1);
        if (hasCycle) {
            return false;
        }

        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(Graph g, int v, boolean[] visited, int parent) {
        visited[v] = true;

        if (g.adj[v] != null) {
            for (int i : g.adj[v]) {
                if (i == parent) {
                    continue;
                }
                if (visited[i]) {
                    return true;
                }
                if (hasCycle(g, i, visited, v)) {
                    return true;
                }
            }
        }
        return false;
    }


    static class Graph {
        int vertices;
        List<Integer>[] adj;

        Graph(int n) {
            this.vertices = n;
            adj = new List[n];
        }

        void addEdge(int x, int y) {
            if (adj[x] == null) {
                adj[x] = new ArrayList<>();
            }
            if (adj[y] == null) {
                adj[y] = new ArrayList<>();
            }
            adj[x].add(y);
            adj[y].add(x);

        }
    }

    public static void main(String[] args) {
        ValidTree vt = new ValidTree();
        int[][] e = {{0, 1}};
        System.out.println(vt.validTree(2, e));
    }
}
