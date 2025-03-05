package cn.dong.leetcode

/**
 * [560. 和为 K 的子数组 - 力扣（LeetCode）](https://leetcode.cn/problems/subarray-sum-equals-k)
 */
class Solution560 {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var count = 0
        var preSum = 0
        val preToCount = mutableMapOf<Int, Int>() // <preSum, count of preSum>
        preToCount[0] = 0

        for (num in nums) {
            preSum += num
            // 前面的前缀和中，值等于 preSum - k 的有几个，就是有几个子数组的和等于 k
            count += preToCount.getOrDefault(preSum - k, 0)

            preToCount[preSum] = preToCount.getOrDefault(preSum, 0)
        }
        return count
    }
}
