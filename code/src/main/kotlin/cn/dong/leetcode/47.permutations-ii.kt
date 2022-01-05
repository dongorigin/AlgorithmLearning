package cn.dong.leetcode

import io.kotest.matchers.shouldBe

/**
 * [47. 全排列 II - 力扣（LeetCode）](https://leetcode-cn.com/problems/permutations-ii/)
 *
 * @author dong on 2022/01/05.
 */
class Solution47 {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()
        val state = State(nums)
        dfs(state, result)
        return result
    }

    private class State(
        val nums: IntArray
    ) {
        val path = ArrayList<Int>(nums.size)
        val used = BooleanArray(nums.size)
    }

    private fun dfs(state: State, result: MutableList<List<Int>>) {
        if (state.path.size == state.nums.size) {
            result.add(state.path.toList())
            return
        }

        var last: Int? = null
        for ((index, num) in state.nums.withIndex()) {
            if (state.used[index] || num == last) {
                continue
            }
            last = num

            state.path.add(num)
            state.used[index] = true

            dfs(state, result)

            state.path.removeAt(state.path.size - 1)
            state.used[index] = false
        }
    }
}

fun main() {
    Solution47().permuteUnique(intArrayOf(1, 1, 2)) shouldBe listOf(listOf(1, 1, 2), listOf(1, 2, 1), listOf(2, 1, 1))
}
