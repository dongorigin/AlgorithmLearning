package cn.dong.leetcode

import io.kotest.matchers.shouldBe

class Solution153 {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[left] < nums[right]) {
                // range [left, right] is sorted
                break
            } else {
                if (nums[left] <= nums[mid]) {
                    // range [left, mid] is sorted
                    left = mid + 1
                } else {
                    // range [mid, right] is sorted
                    right = mid
                }
            }
        }
        return nums[left]
    }
}

fun main() {
    Solution153().findMin(intArrayOf(3, 4, 5, 1, 2)) shouldBe 1
    Solution153().findMin(intArrayOf(2, 1)) shouldBe 1
}