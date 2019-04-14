package com.ds.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * #207. Course Schedule
 * <p>
 * There are a total of n courses you have to take, labeled from 0 to n-1. *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1] *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * <p>
 * Example 1:
 * <p>
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * <p>
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should
 * also have finished course 1. So it is impossible.
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses == 0) {
            return false;
        }

        if (numCourses == 1 || prerequisites.length == 0) {
            return true;
        }
        SimpleGraph graph = new SimpleGraph(numCourses);

        for (int i = 0; i < prerequisites.length; i++) {
            graph.addEdge(prerequisites[i][0], prerequisites[i][1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] competed = new boolean[numCourses];
        boolean[] inProgress = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i]) {
                continue;
            }
            if (checkIfCycle(graph, i, visited, competed, inProgress)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkIfCycle(SimpleGraph g, int v, boolean[] visited, boolean[] completed, boolean[] inProgress) {
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

                if (checkIfCycle(g, i, visited, completed, inProgress)) {
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
        CourseSchedule cs = new CourseSchedule();
        System.out.println(cs.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
