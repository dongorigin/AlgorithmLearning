package cn.dong.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * @author dong on 2018/10/30.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) return new int[]{};
        HashMap<Integer, Integer> map = new HashMap<>(); // <value, index>
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                return new int[]{i, index};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 7, 11, 15};
        int[] output = twoSum(input, 9);
        System.out.println(Arrays.toString(output));
    }
}
