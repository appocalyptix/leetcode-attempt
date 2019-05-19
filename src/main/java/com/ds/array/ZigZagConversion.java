package com.ds.array;


/**
 * 6. ZigZag Conversion
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows) {
            return s;
        }

        boolean forward = true;
        int i = 0;
        StringBuilder[] sb = new StringBuilder[numRows];

        for (int j = 0; j < sb.length; j++) {
            sb[j] = new StringBuilder();
        }

        while (i < s.length()) {
            if (forward) {
                for (int j = 0; j < numRows && i < s.length(); j++) {
                    sb[j].append(s.charAt(i));
                    i++;
                }
                forward = false;
            }
            if (!forward) {
                for (int j = numRows - 2; j > 0 && i < s.length(); j--) {
                    sb[j].append(s.charAt(i));
                    i++;
                }
                forward = true;
            }
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder b : sb) {
            res.append(b);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion zz = new ZigZagConversion();
        System.out.println(zz.convert("PAYPALISHIRING", 4));
        System.out.println("PINALSIGYAHRPI");
    }
}
