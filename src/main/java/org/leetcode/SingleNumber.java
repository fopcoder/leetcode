package org.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public static void main(String[] args) {
        System.err.println(singleNumber2(new int[]{1, 2, 3, 2, 3}));
        System.err.println(singleNumber2(new int[]{1, 2, 3, 2, 3, 1}));
    }

    public static int singleNumber2(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.stream(nums)
                .forEach(key -> {
                    map.compute(key, (k, v) -> map.get(k) == null ? 1 : map.get(k) + 1);
                });

        return map.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().get();
    }
}
