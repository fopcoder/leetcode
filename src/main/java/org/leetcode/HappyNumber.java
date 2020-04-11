package org.leetcode;

import java.util.LinkedList;
import java.util.List;

public class HappyNumber {

    private static final int MAX_TRIES = 100;

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.err.println(happyNumber.isHappy(48));
    }

    public boolean isHappy(int n) {
        int sum = n;
        int count = 0;

        while (!isHappyNumber(sum)) {
            List<Integer> digits = splitNumber(sum);
            sum = getSumOfSquares(digits);

            if (++count > MAX_TRIES) return false;
        }

        return true;
    }

    public List<Integer> splitNumber(int number) {
        List<Integer> list = new LinkedList<>();

        int iter = number;

        while (iter > 0) {
            int digit = iter % 10;
            iter /= 10;
            list.add(0, digit);
        }

        return list;
    }

    public int getSumOfSquares(List<Integer> digits) {
        int sum = 0;

        for (Integer val : digits) {
            sum += val * val;
        }

        return sum;
    }

    public boolean isHappyNumber(int sum) {
        return sum == 1;
    }
}
