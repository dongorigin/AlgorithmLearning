package cn.dong.leetcode

import io.kotest.matchers.shouldBe

/**
 * [209. 长度最小的子数组 - 力扣（LeetCode）](https://leetcode-cn.com/problems/minimum-size-subarray-sum/)
 *
 * @author dong on 2021/12/22.
 */
class Solution209 {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0
        var minLength = 0
        var sum = 0
        for (right in nums.indices) {
            sum += nums[right]
            // 单调性：从满足要求，变成不满足要求
            while (sum >= target) {
                val length = right - left + 1
                if (minLength == 0 || length < minLength) {
                    minLength = length
                }

                sum -= nums[left]
                left++
            }
        }
        return minLength
    }
}

fun main() {
    Solution209().minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)) shouldBe 2
}
