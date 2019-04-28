package com.ds.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<Node>> map = new HashMap<>();

        for (int i = 0; i < equations.length; i++ ) {
            Node a = new Node(equations[i][1], values[i]);
            Node b = new Node(equations[i][0], 1 / values[i]);
            addToMap(map, a, equations[i][0]);
            addToMap(map, b, equations[i][1]);
        }
        double[] res = new double[queries.length];

        for(int i = 0; i < queries.length; i ++) {
            String[] s = queries[i];
            if(s[0].equals(s[1])) {
                res[i] = 1;
            } else if(!map.containsKey(s[0]) || !map.containsKey(s[1])) {
                res[i] = -1;
            } else {
                Queue<Node> q = new ArrayDeque<>();
                q.add(new Node(s[0], 1));
                res[i] = bfs(map, s[1], q);
            }
        }
        return res;
    }
    //Make shortest path not bfs
    private double bfs(Map<String, List<Node>> map, String d, Queue<Node> q) {
        Set<String> s = new HashSet<>();
        double res = 1;

        while (!q.isEmpty()) {
            Node n = q.poll();
            if (s.contains(n.c)) {
                continue;
            }
            s.add(n.c);
            res *= n.w;
            if (d.equals(n.c)) {
                return res;
            }
            List<Node> nodes = map.get(n.c);
            for (int i = 0; i < nodes.size(); i ++) {
                q.add(nodes.get(i));
            }
        }
        return -1;
    }

    private void addToMap(Map<String, List<Node>> map, Node n, String c) {
        if (!map.containsKey(c)) {
            map.put(c, new ArrayList<>());
        }
        map.get(c).add(n);
        //map.get
    }

    static class Node {
        String c;
        double w;
        Node(String c, double w) {
            this.c = c;
            this.w = w;
        }
    }
}
