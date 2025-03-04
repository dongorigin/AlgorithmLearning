package cn.dong.leetcode

import cn.dong.interviews.numberOf1

/**
 * [713. 乘积小于 K 的子数组 - 力扣（LeetCode）](https://leetcode.cn/problems/subarray-product-less-than-k/)
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 *
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 */
class Solution713 {
    // O(n^2)
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        var count = 0
        for (start in nums.indices) {
            var result = 1
            var end = start
            while (end < nums.size) {
                result *= nums[end]
                if (result < k) {
                    count++
                    end++
                } else {
                    break
                }
            }
        }
        return count
    }

    // O(n)，通过滑动窗口减少重复计算
    fun numSubarrayProductLessThanK2(nums: IntArray, k: Int): Int {
        var count = 0
        var product = 1
        var start = 0
        for (end in nums.indices) {
            product *= nums[end]
            while (product >= k) { // 不满足需求
                product /= nums[start]
                start++
            }
            // 以 end 结尾的子数组，包括 [start, end], [start+1, end] ... [end, end], 总计 end - start + 1 个
            count += end - start + 1
        }
        return count
    }
}