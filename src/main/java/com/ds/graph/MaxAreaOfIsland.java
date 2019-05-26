package com.ds.graph;

/**
 * 695. Max Area of Island
 * <p>
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected
 * 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 * <p>
 * Example 1:
 * <p>
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * <p>
 * Example 2:
 * <p>
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int val = dfs(i, j, grid);
                    max = Math.max(max, val);
                }
            }
        }

        return max;
    }

    private int dfs(int x, int y, int[][] a) {
        if (x < 0 || y < 0 || x >= a.length || y >= a[0].length) {
            return 0;
        }
        if (a[x][y] == 0) {
            return 0;
        }
        a[x][y] = 0;
        int c1 = dfs(x + 1, y, a);
        int c2 = dfs(x - 1, y, a);
        int c3 = dfs(x, y + 1, a);
        int c4 = dfs(x, y - 1, a);
        return c1 + c2 + c3 + c4 + 1;
    }
}
