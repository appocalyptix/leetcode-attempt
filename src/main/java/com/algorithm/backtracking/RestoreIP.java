package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 93. Restore IP Addresses
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * Example:
 * <p>
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIP {

    public static void main(String[] args) {
        RestoreIP rip = new RestoreIP();
        List<String> l = rip.restoreIpAddresses("010010");

        for (String s : l) {
            System.out.println(s);
        }
    }

    public List<String> restoreIpAddresses(String s) {

        if (s == null || s.length() < 4 || s.length() > 16) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        restoreIpHelper(s, 4, res, temp);
        return res;
    }

    public void restoreIpHelper(String s, int block, List<String> res, List<Integer> temp) {
        if (block == 0) {
            if (s.length() == 0) {
                String str = "";
                for (Integer a : temp) {
                    str = str + a + ".";
                }
                str = str.substring(0, str.lastIndexOf('.'));
                res.add(str);
            }
            return;
        }

        if (s.length() > block * 4 || s.length() < block) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (s.length() >= i) {
                String s1 = s.substring(0, i);
                Integer i1 = Integer.parseInt(s1);
                if (Integer.parseInt(s1) < 256) {
                    String s2 = s.substring(i);
                    temp.add(i1);
                    restoreIpHelper(s2, block - 1, res, temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}
