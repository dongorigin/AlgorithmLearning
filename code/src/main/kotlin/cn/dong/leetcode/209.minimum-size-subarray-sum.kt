package cn.dong.leetcode

import io.kotest.matchers.shouldBe

/**
 * [209. 长度最小的子数组 - 力扣（LeetCode）](https://leetcode-cn.com/problems/minimum-size-subarray-sum/)
 *
 * @author dong on 2021/12/22.
 */
class Solution209 {
    // [left, right)
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0
        var right = 0
        var minLen = 0
        var sum = 0
        for (right in 0 until nums.size) {
            sum += nums[right]
            while (sum >= target) {
                val len = right - left + 1
                if (minLen == 0 || len < minLen) {
                    minLen = len
                }
                sum -= nums[left]
                left++
            }
        }
        return minLen
    }
}

fun main() {
    Solution209().minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)) shouldBe 2
}
