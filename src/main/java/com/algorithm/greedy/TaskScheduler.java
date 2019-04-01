package com.algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * #621 Task Scheduler
 * <p>
 * *Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters
 * represent different tasks.  Tasks could be done without original order. Each task could be done in one interval.
 * For each interval, CPU could finish one task or just be idle.  However, there is a non-negative cooling interval
 * n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just
 * be idle.
 * <p>
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * <p>
 * Example:
 * <p>
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {

        int taskCount = tasks.length;
        if (n == 0) {
            return taskCount;
        }

        Map<Character, Integer> tasksMap = new HashMap<>();
        Map<Character, Integer> coolDownMap = new HashMap<>();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < taskCount; i++) {
            int count = 1;
            if (tasksMap.containsKey(tasks[i])) {
                count += tasksMap.get(tasks[i]);
            } else {
                list.add(tasks[i]);
            }
            tasksMap.put(tasks[i], count);
        }

        int count = 0;
        int i = 0;

        while (!tasksMap.isEmpty()) {
            int index = i % list.size();
            Character task = list.get(index);
            if (tasksMap.containsKey(task) && !coolDownMap.containsKey(task)) {
                coolDownMap.put(task, 3);
                int remainingTask = tasksMap.get(task) - 1;
                if (remainingTask > 0) {
                    tasksMap.replace(task, remainingTask);
                } else {
                    tasksMap.remove(task);
                    list.remove(index);
                    i--;
                }
            }
            i++;
        }

        return count;
    }
}
