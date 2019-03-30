package com.ds.queue;

import java.util.Arrays;
import java.util.Comparator;

/**
 * #253. Meeting Rooms II
 * <p>
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 * <p>
 * Example 1:
 * <p>
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: [[7,10],[2,4]]
 * Output: 1
 */
public class MeetingRooms {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length <= 1) {
            return intervals.length;
        }
        Arrays.sort(intervals, new IntervalComparator());
        int[] meetingRooms = new int[intervals.length];
        Arrays.fill(meetingRooms, -1);


        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < meetingRooms.length; j++) {
                if (intervals[i].start >= meetingRooms[j]) {
                    meetingRooms[j] = intervals[i].end;
                    break;
                }
            }
        }
        int count = 0;
        for (int i : meetingRooms) {
            if (i == -1) {
                break;
            }
            count++;
        }
        return count;
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
        MeetingRooms mr = new MeetingRooms();
        Interval[] i = {new Interval(5, 10), new Interval(0, 30), new Interval(15, 20), new Interval(11, 14),};
        System.out.println(mr.minMeetingRooms(i));
    }
}
