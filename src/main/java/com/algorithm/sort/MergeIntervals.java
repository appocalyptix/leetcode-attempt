package com.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * #56. Merge Intervals
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        List<Interval> list = new ArrayList<>();
        Collections.sort(intervals, new IntervalComparator());

        int index = 1;
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        while (index < intervals.size()) {
            if (end < intervals.get(index).start) {
                list.add(new Interval(start, end));
                start = intervals.get(index).start;
            }
            end = Math.max(end, intervals.get(index).end);
            index++;
        }
        list.add(new Interval(start, end));
        return list;
    }

    private static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            if (o1.start == o2.start) {
                if (o1.end == o2.end) {
                    return 0;
                }
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        }
    }

    private static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        //  List<Interval> l = Arrays.asList(new Interval(1, 3), new Interval(2, 6), new Interval(8, 10), new Interval(15, 8));
        List<Interval> l = Arrays.asList(new Interval(1, 4), new Interval(2, 3));
        MergeIntervals ml = new MergeIntervals();
        List<Interval> l2 = ml.merge(l);

        for (Interval i : l2) {
            System.out.println(i.start + " -> " + i.end);
        }
    }
}
