package org.leetcode;

public class MaxSubarrayKadane {
    public static void main(String[] args) {
        MaxSubarrayKadane maximumSubarray = new MaxSubarrayKadane();
        System.err.println(maximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.err.println(maximumSubarray.maxSubArray(new int[]{-1}));
        System.err.println(maximumSubarray.maxSubArray(new int[]{-2, -1}));
    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int current_sum = 0;

        for (int num : nums) {
            current_sum += num;

            if (current_sum > max) {
                max = current_sum;
            }

            if (current_sum < 0) {
                current_sum = 0;
            }
        }

        return max;
    }

}
