package com.ds.array;

import java.util.Arrays;

public class TaskScheduler {
    /**
     * 621. Task Scheduler
     * <p>
     * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters
     * represent different tasks. Tasks could be done without original order. Each task could be done in one interval.
     * For each interval, CPU could finish one task or just be idle.
     * <p>
     * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least
     * n intervals that CPU are doing different tasks or just be idle.
     * <p>
     * You need to return the least number of intervals the CPU will take to finish all the given tasks.
     * <p>
     * Example:
     * <p>
     * Input: tasks = ["A","A","A","B","B","B"], n = 2
     * Output: 8
     * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
     */
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }

        int[] arr = new int[26];

        for (char c : tasks) {
            arr[c - 'A']++;
        }
        Arrays.sort(arr);
        int res = 0;
        while (arr[25] != 0) {
            for (int i = 0; i <= n; i++) {

                if ((25 - i) >= 0 && arr[25 - i] > 0) {
                    arr[25 - i]--;
                    res++;
                } else if (arr[25] > 0) {
                    res++;
                }
            }
            Arrays.sort(arr);
        }
        return res;
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        char[] cc = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(ts.leastInterval(cc, 50));
    }
}
