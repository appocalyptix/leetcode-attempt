package com.slidingwindow;

public class MaxConsicutiveOnes {
    public int longestOnes(int[] a, int k) {
        if (k >= a.length) {
            return a.length;
        }
        int maxCount = 0;
        int currentCount = 0;
        int kLeft = k;
        int startIndex = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                currentCount++;
            } else if (a[i] == 0 && kLeft > 0) {
                currentCount++;
                kLeft--;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
                if (a[startIndex] == 0) {
                    kLeft++;
                }
                currentCount--;
                i--;
                startIndex++;
            }
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        MaxConsicutiveOnes maxConsicutiveOnes = new MaxConsicutiveOnes();
        int[] a = {1,1,1,0,0,0,1,1,1,1};
        System.out.println(maxConsicutiveOnes.longestOnes(a, 0));
    }
}
