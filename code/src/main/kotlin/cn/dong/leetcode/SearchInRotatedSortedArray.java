package cn.dong.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 *
 * @author dong on 2018/11/04.
 */
public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];
            if (target == midVal) {
                return mid;
            }
            if (nums[low] <= midVal) {
                // left is sorted, right is rotated.
                if (nums[low] <= target && target < midVal) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // left is rotated, right is sorted.
                if (midVal < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        assertEquals(0, search(new int[]{1}, 1));
        assertEquals(-1, search(new int[]{1}, 2));

        int[] input = {4, 5, 6, 7, 0, 1, 2};
        assertEquals(4, search(input, 0));
        assertEquals(-1, search(input, 3));

        int[] input2 = {3, 1};
        assertEquals(0, search(input2, 3));
        assertEquals(1, search(input2, 1));
    }
}
