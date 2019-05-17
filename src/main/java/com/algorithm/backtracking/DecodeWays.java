package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class DecodeWays {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
            list.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        }
        int[] res = new int[1];
        numDecodingsRec(1, arr, 0, res);
        return res[0];
    }

    private void numDecodingsRec(int val, int[] arr, int index, int[] res) {
        if (val > 26 || val == 0) {
            return;
        }

        if (index == arr.length) {
            res[0]++;
            return;
        }
        if (arr[index] == 0) {
            return;
        }

        int i1 = arr[index];
        numDecodingsRec(i1, arr, index + 1, res);
        if (index + 1 < arr.length) {
            int i2 = arr[index + 1];
            numDecodingsRec(i1 * 10 + i2, arr, index + 2, res);
        }
    }


    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
        System.out.println(dw.numDecodings("226"));
    }
}
