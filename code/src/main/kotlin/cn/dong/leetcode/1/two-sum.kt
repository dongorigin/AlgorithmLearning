package cn.dong.leetcode.`1`

/**
 * [1. 两数之和 - 力扣（LeetCode）](https://leetcode.cn/problems/two-sum)
 */
class Solution_1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>() // num, Index

        for (i in 0..nums.size -1 ) {

            val num = nums[i]

            val expectedNum = target - num
            val index = map[expectedNum]
            if (index != null) {
                return intArrayOf(index, i)
            } else {
                map[num] = i
            }
        }
        return intArrayOf(0)
    }
}