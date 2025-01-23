package cn.dong.leetcode

import kotlin.test.assertEquals

/**
 * [704. 二分查找 - 力扣（LeetCode）](https://leetcode-cn.com/problems/binary-search/)
 *
 * @author dong on 2021/12/21.
 */
class Solution704 {
    // [low, high]
    fun search(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size - 1
        while (low <= high) {
            val mid = low + (high - low) / 2
            val midVal = nums[mid]
            if (midVal == target) {
                return mid
            } else if (target > midVal) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        return -1
    }
}

class Solution704_Recursion {

    fun search(nums: IntArray, target: Int): Int {
        return binarySearch(nums, target, 0, nums.size - 1)
    }

    private fun binarySearch(nums: IntArray, target: Int, start: Int, end: Int): Int {
        if (start > end) return -1

        val midIndex = start + (end - start) / 2
        val mid = nums[midIndex]
        if (target == mid) {
            return midIndex
        } else if (target < mid) {
            return binarySearch(nums, target, start, midIndex - 1)
        } else {
            return binarySearch(nums, target, midIndex + 1, end)
        }
    }
}

fun main() {
    val array = intArrayOf(-1,0,3,5,9,12)

    assertEquals(4, Solution704_Recursion().search(array, 9))
    assertEquals(-1, Solution704_Recursion().search(array, 2))
}
