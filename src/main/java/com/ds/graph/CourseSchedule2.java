package com.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * #210. Course Schedule II
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: [0,1]
 *
 * Example 2:
 *
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 */
public class CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (numCourses == 0) {
            return new int[0];
        }

        SimpleGraph graph = new SimpleGraph(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            graph.addEdge(prerequisites[i][0], prerequisites[i][1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] completed = new boolean[numCourses];
        boolean[] inProgress = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i]) {
                continue;
            }
            if (hasCycle(graph, i, visited, completed, inProgress)) {
                return new int[0];
            }
        }

        Arrays.fill(visited, false);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (visited[i]) {
                continue;
            }

            topSort(graph, i, visited, stack);
        }

        int[] result = new int[stack.size()];
        int index = stack.size() - 1;

        while (!stack.isEmpty()) {
            result[index] = stack.pop();
            index--;
        }
        return result;
    }

    private void topSort(SimpleGraph graph, int v, boolean[] visited, Stack<Integer> stack) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        if (graph.adj[v] != null) {
            for (Integer i : graph.adj[v]) {
                topSort(graph, i, visited, stack);
            }
        }
        stack.add(v);
    }

    private boolean hasCycle(SimpleGraph g, int v, boolean[] visited, boolean[] completed, boolean[] inProgress) {
        visited[v] = true;
        inProgress[v] = true;

        if (g.adj[v] != null) {

            for (Integer i : g.adj[v]) {
                if (completed[i]) {
                    continue;
                }
                if (inProgress[i]) {
                    return true;
                }

                if (hasCycle(g, i, visited, completed, inProgress)) {
                    return true;
                }
            }
        }

        inProgress[v] = false;
        completed[v] = true;
        return false;
    }

    private static class SimpleGraph {
        int vertices;
        List<Integer>[] adj;

        SimpleGraph(int vertices) {
            this.vertices = vertices;
            this.adj = new List[vertices];
        }

        void addEdge(int x, int y) {
            if (adj[x] == null) {
                adj[x] = new ArrayList<>();
            }
            adj[x].add(y);
        }

    }

    public static void main(String[] args) {
        CourseSchedule2 cs = new CourseSchedule2();
        int[] i = cs.findOrder(2, new int[][]{{0, 1}, {1, 0}});

        for (int x : i) {
            System.out.println(x);
        }

    }
}
