package org.leetcode;

public class MaxSubarrayDivide {
    public static void main(String[] args) {
        MaxSubarrayDivide maxSubarray = new MaxSubarrayDivide();

        System.err.println(maxSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.err.println(maxSubarray.maxSubArray(new int[]{-1}));
        System.err.println(maxSubarray.maxSubArray(new int[]{-2, -1}));

    }

    public int maxSubArray(int[] nums) {
        return maxSum(nums, 0, nums.length - 1);
    }

    private int maxSum(int[] arr, int leftIdx, int rightIdx) {
        if (leftIdx == rightIdx) {
            return arr[leftIdx];
        }

        int middleIdx = getMiddleIdx(leftIdx, rightIdx);

        return Math.max(
            maxSum(arr, leftIdx, middleIdx),
            maxSum(arr, middleIdx + 1, rightIdx)
        );
    }

    private int getMiddleIdx(int leftIdx, int rightIdx) {
        return (leftIdx + rightIdx) / 2;
    }
}
