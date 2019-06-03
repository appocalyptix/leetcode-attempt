package com.ds.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IntegerToEnglish {
    Map<Integer, String> map;
    public String numberToWords(int num) {

        return null;
    }


    private void getThreeDigit(int i, StringBuilder sb) {

        int i1 = i / 100;
        int i2 = i % 100;
        if (i1 > 0) {
            sb.append(map.get(i));
            sb.append("hundred");
        }
        getTwoDigit(i2, sb);
    }

    private void getTwoDigit(int i, StringBuilder sb) {
        if (i > 9 && i < 20) {
            sb.append(map.get(i));
        } else {
            sb.append(map.get(i));
            sb.append(map.get(i %10));
            List<Integer> l = new ArrayList<>();
            //Integer.va
        }
    }

    private void populate() {
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(0, "");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(14, "fourteen");
        map.put(15, "fifteen");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");
        map.put(20, "twenty");
        map.put(30, "thirty");
        map.put(40, "forty");
        map.put(50, "fifty");
        map.put(60, "sixty");
        map.put(70, "seventy");
        map.put(80, "eighty");
        map.put(90, "ninety");
    }
    private String getSuffix(int length) {
        if (length > 9) {
            return "billion";
        } else if(length > 6) {
            return "million";
        } else if (length > 3) {
            return  "thousand";
        } else if (length > 2) {
            return "hundred";
        } else  {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
