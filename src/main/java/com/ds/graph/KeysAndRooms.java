package com.ds.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * #841. Keys and Rooms
 *
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1,
 * and each room may have some keys to access the next room. Formally, each room i has a list of keys
 * rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.
 * A key rooms[i][j] = v opens the room with number v.  Initially, all the rooms start locked (except for room 0).
 * You can walk back and forth between rooms freely.
 * Return true if and only if you can enter every room.
 *
 * Example 1:
 *
 * Input: [[1],[2],[3],[]]
 * Output: true
 *
 * Example 2:
 *
 * Input: [[1,3],[3,0,1],[2],[0]]
 * Output: false
 */
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> q = new ArrayDeque();
        q.add(0);
        bst(rooms, visited, q);

        for (boolean b : visited) {
            if(!b) {
                return false;
            }
        }
        return true;

    }

    private void bst(List<List<Integer>> rooms, boolean[] visited, Queue<Integer> q) {

        while (!q.isEmpty()) {
            int v = q.poll();

            if(visited[v]) {
                continue;
            }

            visited[v] = true;

            if(rooms.get(v) != null && rooms.get(v).size() > 0) {
                for(Integer i : rooms.get(v)) {
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 3));
        list.add(Arrays.asList(3, 0, 1));
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(0));
       // list.add(new ArrayList<>());

        KeysAndRooms kr = new KeysAndRooms();
        System.out.println(kr.canVisitAllRooms(list));
    }
}
