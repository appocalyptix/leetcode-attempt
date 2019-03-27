package com.slidingwindow;

/**
 * #424
 * Given a string that consists of only uppercase English letters, you can replace any letter in the
 * string with another letter at most k times. Find the length of a longest substring containing all
 * repeating letters you can get after performing the above operations.
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        if (k >= s.length()) {
            return s.length();
        }
        int maxLength = 0;
        int[] count = new int[26];
        int windowStart = 0;
        int length = 0;
        for (int i = 0; i < s.length() && windowStart < s.length(); i++) {
            count[s.charAt(i) - 'A']++;
            if (getCount(count) > k) {
                maxLength = Math.max(maxLength, length);
                count[s.charAt(windowStart) - 'A']--;
                windowStart++;
                count[s.charAt(i) - 'A']--;
                i--;
                length --;
            } else {
                length++;
            }
        }
        return Math.max(maxLength, length);
    }

    private int getCount(int[] a) {
        int sum = 0;
        int max = 0;

        for (int i : a) {
            max = Math.max(max, i);
            sum += i;
        }
        return sum - max;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement l = new LongestRepeatingCharacterReplacement();
        System.out.println(l.characterReplacement("ABAA", 0));
    }
}
