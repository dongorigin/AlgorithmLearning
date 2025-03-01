package cn.dong.leetcode

/**
 * [128. 最长连续序列 - 力扣（LeetCode）](https://leetcode.cn/problems/longest-consecutive-sequence)
 */
class Solution128 {
    fun longestConsecutive(nums: IntArray): Int {
        val numToLength = mutableMapOf<Int, Int>() // number, sequence length of this number
        var max = 0
        for (num in nums) {
            val length = numToLength.getOrDefault(num, 0)
            if (length == 0) {
                // new num
                val preLength = numToLength.getOrDefault(num - 1, 0)
                val nextLength = numToLength.getOrDefault(num + 1, 0)
                val newLength = 1 + preLength + nextLength
                numToLength[num] = newLength
                if (preLength != 0) {
                    numToLength[num - preLength] = newLength
                }
                if (nextLength != 0) {
                    numToLength[num + nextLength] = newLength
                }
                if (newLength > max) {
                    max = newLength
                }
            } else {
                // the num exists
            }
        }
        return max
    }
}