package org.leetcode;

import java.util.stream.IntStream;

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

        return IntStream.of(
            maxSumMiddle(arr, leftIdx, middleIdx, rightIdx),
            maxSum(arr, leftIdx, middleIdx),
            maxSum(arr, middleIdx + 1, rightIdx)
        ).max().orElse(0);
    }

    private int maxSumMiddle(int[] arr, int leftIdx, int middleIdx, int rightIdx) {
        int sumLeft = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = middleIdx; i >= leftIdx; i--) {
            sum += arr[i];
            if (sum > sumLeft) {
                sumLeft = sum;
            }
        }

        int sumRight = Integer.MIN_VALUE;
        sum = 0;
        for (int i = middleIdx + 1; i <= rightIdx; i++) {
            sum += arr[i];
            if (sum > sumRight) {
                sumRight = sum;
            }
        }

        return sumLeft + sumRight;
    }

    private int getMiddleIdx(int leftIdx, int rightIdx) {
        return (leftIdx + rightIdx) / 2;
    }
}
