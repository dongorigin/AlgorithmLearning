package cn.dong.leetcode

import io.kotest.matchers.shouldBe

/**
 * [47. 全排列 II - 力扣（LeetCode）](https://leetcode-cn.com/problems/permutations-ii/)
 * @author dong on 2022/01/05.
 */
class Solution47 {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        nums.sort()
        return permute(nums.toList())
    }

    fun permute(nums: List<Int>): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (nums.size == 0) {
            return result
        }
        if (nums.size == 1) {
            result.add(listOf(nums.first()))
            return result
        }

        // 第一位数字固定 + 剩下数字的全排列
        // 第一位数字不能重复，排序+记录上一个
        var lastNum: Int? = null
        for ((index, num) in nums.withIndex()) {
            if (num == lastNum) continue
            lastNum = num

            val remainNums = nums.toMutableList()
            remainNums.removeAt(index)
            for (remainPermute in permute(remainNums)) {
                val list = mutableListOf(num)
                list.addAll(remainPermute)
                result.add(list)
            }
        }
        return result
    }
}

fun main() {
    Solution47().permuteUnique(intArrayOf(1, 1, 2)) shouldBe listOf(listOf(1, 1, 2), listOf(1, 2, 1), listOf(2, 1, 1))
}