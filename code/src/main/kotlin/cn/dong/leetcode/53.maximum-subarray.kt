package cn.dong.leetcode

import kotlin.math.max

/**
 * [53. 最大子数组和 - 力扣（LeetCode）](https://leetcode.cn/problems/maximum-subarray/)
 */
class Solution53 {
    fun maxSubArray(nums: IntArray): Int {
        // 第一个数必须是正数，否则纯亏损
        // 如果遇到负数
        // - 和是正数，继续相加
        // - 和是负数，放弃前面所有，从下一位开始相加

        var sum = 0
        var maxSum = Int.MIN_VALUE
        for (num in nums) {
            sum += num
            maxSum = max(sum, maxSum)

            if (sum < 0) {
                sum = 0 // 放弃前面的累加，从下一位重新开始累加
            }
        }
        return maxSum
    }
}

fun main() {
    println(Solution53().maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
}