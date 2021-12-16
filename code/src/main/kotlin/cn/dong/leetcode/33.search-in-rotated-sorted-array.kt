package cn.dong.leetcode

import io.kotest.matchers.shouldBe

/**
 * [33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/submissions/)
 *
 * @author dong on 2021/12/16.
 */
fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = (left + right) / 2
        if (target == nums[mid]) {
            return mid
        } else {
            if (nums[mid] < nums[right]) { // left may be equals mid, so need compare right
                // right range is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            } else {
                // left range is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
        }
    }
    return -1
}

fun main() {
    search(intArrayOf(3, 1), 1) shouldBe 1
}
