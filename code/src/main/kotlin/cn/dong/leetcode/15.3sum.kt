package cn.dong.leetcode

import io.kotest.matchers.shouldBe

/**
 * [15. 三数之和 - 力扣（LeetCode）](https://leetcode-cn.com/problems/3sum/)
 * @author dong on 2022/01/03.
 */
class Solution15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()
        for (first in 0..nums.size - 3) {
            if (first > 0 && nums[first] == nums[first - 1]) continue

            var second = first + 1
            var third = nums.size - 1
            val target = -nums[first]
            while (second < third) {
                if (nums[second] + nums[third] == target) {
                    result.add(listOf(nums[first], nums[second], nums[third]))
                    second++
                    third--
                    while (second < third && nums[second] == nums[second - 1]) {
                        second++
                    }
                    while (second < third && nums[third] == nums[third + 1]) {
                        third--
                    }
                } else if (nums[second] + nums[third] > target) {
                    third--
                } else {
                    second++
                }
            }
        }
        return result
    }
}

fun main() {
    Solution15().threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)) shouldBe listOf(listOf(-1, -1, 2), listOf(-1, 0, 1))
}