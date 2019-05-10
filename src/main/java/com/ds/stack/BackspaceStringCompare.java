package com.ds.stack;

import java.util.Stack;

/**
 * 844. Backspace String Compare
 *
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 * <p>
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        return getModifiedString(s).equals(getModifiedString(t));
    }

    private String getModifiedString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        BackspaceStringCompare bc = new BackspaceStringCompare();
        System.out.println(bc.backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
