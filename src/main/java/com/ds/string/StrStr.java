package com.ds.string;

public class StrStr {
    public int strStr(String haystack, String needle) {

        if (needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }

        int n = 0;
        int index = -1;

        boolean isMatch = false;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(n)) {
                if (!isMatch) {
                    isMatch = true;
                    index = i;
                }
                n++;
                if (n == needle.length()) {
                    return index;
                }
            } else {
                if (isMatch) {
                    i = index;
                }
                isMatch = false;
                n = 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr ss = new StrStr();
        System.out.println(ss.strStr("mississippi", "pi"));
    }
}
