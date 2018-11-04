package cn.dong.leetcode;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 *
 * @author dong on 2018/11/04.
 */
public class SearchInRotatedSortedArray {

    public static int search(final int[] nums, final int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public static int search(final int[] nums, final int target, final int low, final int high) {
        if (low > high) return -1; // recursion exit
        final int mid = (low + high) >>> 1;
        final int midVal = nums[mid];
        if (midVal == target) {
            return mid; // hit
        }
        if (midVal >= nums[low]) {
            // left is sorted, right is rotated
            if (nums[low] <= target && target < midVal) {
                return searchInSortedRange(nums, target, low, mid - 1);
            } else {
                return search(nums, target, mid + 1, high);
            }
        } else {
            // left is rotated, right is sorted
            if (midVal < target && target <= nums[high]) {
                return searchInSortedRange(nums, target, mid + 1, high);
            } else {
                return search(nums, target, low, mid - 1);
            }
        }
    }

    public static int searchInSortedRange(int[] nums, int target, int fromIndex, int toIndex) {
        int low = fromIndex;
        int high = toIndex;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];
            if (target < midVal) {
                high = mid - 1;
            } else if (target > midVal) {
                low = mid + 1;
            } else {
                return mid;
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
