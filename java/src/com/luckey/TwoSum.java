package com.luckey;

import com.sun.javafx.scene.traversal.Algorithm;
import com.sun.javafx.scene.traversal.ParentTraversalEngine;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class TwoSum {

    static class Pair {
        Integer value;
        Integer index;

        public Pair(Integer value, Integer index) {
            this.value = value;
            this.index = index;
        }

        Integer getValue() {
            return this.value;
        }

    }

    public static class ValueComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.getValue().compareTo(o2.value);
        }
    }

    public static int[] twoSum(int[] nums, int target) {

        Pair[] number = new Pair[nums.length];
        for (int i = 0; i < number.length; i++) {
            number[i] = new Pair(nums[i], i);
        }

        Arrays.sort(number, new ValueComparator());

        int[] rets = new int[2];

        int left = 0;
        int right = number.length - 1;
        while(left < right) {
            int sum = number[left].getValue() + number[right].getValue();
            if (sum > target) {
                right -= 1;
            } else if (sum < target) {
                left += 1;
            } else {
                rets[0] = Math.min(number[left].index, number[right].index);
                rets[1] = Math.max(number[left].index, number[right].index);
                return rets;
            }
        }

        return rets;
    }

    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                int[] rets = new int[2];
                rets[0] = map.get(nums[i]);
                rets[1] = i;
                return rets;
            }
            map.put(target - nums[i], i);
        }

        return new int[2];
    }

    public static void main(String[] args) {
//        System.out.println("Hello World.");

        int[] nums = new int[]{2, 11, 7, 15};
        int target = 9;

        int[] rets = twoSum(nums, target);
        assert(rets != null);
        System.out.println(rets[0]);
        System.out.println(rets[1]);
        assert(rets.length == 2);
        assert(rets[0] == 0);
        assert(rets[1] == 1);

    }
}
