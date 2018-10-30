package cn.dong.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum
 *
 * @author dong on 2018/10/31.
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // skip same item
            }
            int low = i + 1;
            int high = nums.length - 1;
            int target = 0 - nums[i];
            while (low < high) {
                if (nums[low] + nums[high] == target) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low + 1] == nums[low]) {
                        low++; // skip same item
                    }
                    low++;
                    while (low < high && nums[high - 1] == nums[high]) {
                        high--; // skip same item
                    }
                    high--;
                } else if (nums[low] + nums[high] > target) {
                    high--;
                } else { // < target
                    low++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(input);
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }
}
