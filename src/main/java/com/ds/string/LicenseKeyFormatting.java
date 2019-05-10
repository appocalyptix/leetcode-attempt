package com.ds.string;

/**
 * 482. License Key Formatting
 *
 * You are given a license key represented as a string S which consists only alphanumeric character and dashes.
 * The string is separated into N+1 groups by N dashes.
 * <p>
 * Given a number K, we would want to reformat the strings such that each group contains exactly K characters,
 * except for the first group which could be shorter than K, but still must contain at least one character.
 * Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.
 * <p>
 * Given a non-empty string S and a number K, format the string according to the rules described above.
 * <p>
 * Example 1:
 * Input: S = "5F3Z-2e-9-w", K = 4
 * <p>
 * Output: "5F3Z-2E9W"
 * <p>
 * Explanation: The string S has been split into two parts, each part has 4 characters.
 * Note that the two extra dashes are not needed and can be removed.
 * Example 2:
 * Input: S = "2-5g-3-J", K = 2
 * <p>
 * Output: "2-5G-3J"
 * <p>
 * Explanation: The string S has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("-", "").toUpperCase();
        if (s.length() <= k) {
            return s;
        }
        System.out.println(">>> " + s);
        StringBuilder sb = new StringBuilder();
        int c = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
            c++;
            if (i != 0 && c % k == 0) {
                sb.append("-");
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        LicenseKeyFormatting lf = new LicenseKeyFormatting();
        System.out.println(lf.licenseKeyFormatting("---", 3));

        // String s = "5F3Z-2e-9-w";
        // s = s.toUpperCase();
        // System.out.println(s);
    }
}
