package com.ds.graph;

public class SurroundedRegions {

    public void solve(char[][] board) {

    }

    public boolean dfs(int x, int y, char[][] a) {
        if (x <= 0 || y <= 0 || x >= a.length || y >= a[0].length) {
            if (a[x][y] == '0') {
                a[x][y] = '1';
                return false;
            }
        }
        if(a[x][y] == 'X') {
            return true;
        }
       // boolean b1 = dfs(x +1)
        return false;
    }

    public static void main(String[] args) {
        int i = (Integer.MAX_VALUE)/ 1024;
        System.out.println(i/1024);
    }
}
