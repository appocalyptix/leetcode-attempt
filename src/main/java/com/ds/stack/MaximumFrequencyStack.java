package com.ds.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 895. Maximum Frequency Stack
 * <p>
 * Implement FreqStack, a class which simulates the operation of a stack-like data structure.
 * <p>
 * FreqStack has two functions:
 * <p>
 * push(int x), which pushes an integer x onto the stack.
 * pop(), which removes and returns the most frequent element in the stack.
 * If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * Output: [null,null,null,null,null,null,null,5,7,5,4]
 * Explanation:
 * After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:
 * <p>
 * pop() -> returns 5, as 5 is the most frequent.
 * The stack becomes [5,7,5,7,4].
 * <p>
 * pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
 * The stack becomes [5,7,5,4].
 * <p>
 * pop() -> returns 5.
 * The stack becomes [5,7,4].
 * <p>
 * pop() -> returns 4.
 * The stack becomes [5,7].
 */
public class MaximumFrequencyStack {

    private Map<Integer, Integer> freq;
    private Map<Integer, Stack<Integer>> map;
    private int maxFreq;

    public MaximumFrequencyStack() {
        freq = new HashMap<>();
        map = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int x) {
        int frequency = freq.getOrDefault(x, 0) + 1;
        freq.put(x, frequency);
        maxFreq = Math.max(maxFreq, frequency);
        Stack<Integer> stack = map.getOrDefault(frequency, new Stack<>());
        stack.push(x);
        map.put(frequency, stack);
    }

    public int pop() {
        int res = map.get(maxFreq).pop();
        if (map.get(maxFreq).isEmpty()) {
            maxFreq--;
        }

        int f = freq.get(res);
        if (f == 1) {
            freq.remove(res);
        } else {
            freq.put(res, f - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumFrequencyStack mf = new MaximumFrequencyStack();
        mf.push(5);
        mf.push(7);
        mf.push(5);
        mf.push(7);
        mf.push(4);
        mf.push(5);

        System.out.println(mf.pop());
        System.out.println(mf.pop());
        System.out.println(mf.pop());
        System.out.println(mf.pop());

    }
}
