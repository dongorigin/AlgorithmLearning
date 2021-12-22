package cn.dong.leetcode

/**
 * [977. 有序数组的平方 - 力扣（LeetCode）](https://leetcode-cn.com/problems/squares-of-a-sorted-array/)
 *
 * @author dong on 2021/12/22.
 */
class Solution977 {
    fun sortedSquares(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var left = 0
        var right = nums.size - 1
        var i = right
        while (left <= right) {
            val leftP = nums[left] * nums[left]
            val rightP = nums[right] * nums[right]
            if (leftP > rightP) {
                result[i] = leftP
                left++
            } else {
                result[i] = rightP
                right--
            }
            i--
        }
        return result
    }
}
