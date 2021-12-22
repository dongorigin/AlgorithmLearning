package cn.dong.leetcode

/**
 * [27. 移除元素 - 力扣（LeetCode）](https://leetcode-cn.com/problems/remove-element/)
 *
 * @author dong on 2021/12/22.
 */
class Solution27 {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var k = 0
        for (i in 0 until nums.size) {
            if (nums[i] != `val`) {
                nums[k] = nums[i]
                k++
            }
        }
        return k
    }
}