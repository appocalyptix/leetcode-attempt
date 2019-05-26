package com.ds.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Below solution is not correct
 */
public class NumberIslandII {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        if (positions.length == 0) {
            return Collections.emptyList();
        }

        Set<int[]> set = new HashSet<>();
        set.add(positions[0]);
        int count = 1;
        List<Integer> list = new ArrayList<>();
        list.add(count);

        for (int i = 1; i < positions.length; i++) {
            if(!isAdjacent(positions[i][0], positions[i][1], set)) {
                count++;
            }
            set.add(positions[i]);
            list.add(count);
        }
        return list;
    }

    private boolean isAdjacent(int x, int y, Set<int[]> set) {
        if (set.size() == 0) {
            return false;
        }

        Iterator<int[]> itr = set.iterator();
        while(itr.hasNext()) {
            int[] c = itr.next();
            int xDiff = Math.abs(Math.subtractExact(c[0], x));
            int yDiff = Math.abs(Math.subtractExact(c[1], y));
            if ((xDiff == 1 && yDiff ==0) || (xDiff ==0 && yDiff ==1)) {
                return true;
            }
        }
        return false;
    }

}
