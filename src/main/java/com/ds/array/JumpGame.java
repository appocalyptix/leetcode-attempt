package com.ds.array;

/**
 * #55. Jump Game
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        boolean zeroFound = false;
        int stepsSize = 0;
        while (lastPos - 1 >= 0) {
            if (!zeroFound && nums[lastPos -1] == 0) {
                zeroFound = true;
                lastPos --;
                continue;
            }

            if (zeroFound) {
                if (nums[lastPos - 1] > ++stepsSize) {
                    zeroFound = false;
                    stepsSize = 0;
                }
            }
            lastPos--;
        }
        return !zeroFound;
    }

    public static void main(String[] args) {
        JumpGame game = new JumpGame();
        System.out.println(game.canJump(new int[]{3,2,1,0,4}));
    }
}
