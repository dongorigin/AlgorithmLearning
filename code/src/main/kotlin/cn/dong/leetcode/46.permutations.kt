package cn.dong.leetcode

/**
 * [46. 全排列 - 力扣（LeetCode）](https://leetcode-cn.com/problems/permutations/)
 *
 * @author dong on 2020/08/09.
 */
class Solution46 {
    /** 通过记录与修改状态变量来回溯，减少产生的中间变量 */
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val state = State(nums)
        dfs(state, result)
        return result
    }

    /** 搜索路径状态，用于回溯 */
    private class State(
        val nums: IntArray
    ) {
        val path: MutableList<Int> = mutableListOf()
        val used: BooleanArray = BooleanArray(nums.size)

        fun isUsed(index: Int): Boolean = used[index]
        fun setUsed(index: Int, use: Boolean) {
            used[index] = use
        }
    }

    private fun dfs(state: State, result: MutableList<List<Int>>) {
        if (state.path.size == state.nums.size) {
            result.add(state.path.toList())
            return
        }

        for ((index, num) in state.nums.withIndex()) {
            if (state.isUsed(index)) continue

            state.setUsed(index, true)
            state.path.add(num)

            dfs(state, result)

            state.path.removeAt(state.path.size - 1)
            state.setUsed(index, false)
        }
    }
}

class Solution46_2 {
    /** 产生中间变量较多，性能消耗较大 */
    fun permute(nums: IntArray): List<List<Int>> {
        return permute(emptyList(), nums.toList())
    }

    /**
     * M 个数全排列
     * = 前 1 位固定 + 剩下 M-1 个数全排列
     * = 前 N 位固定 + 剩下 M-N 个数全排列
     * = 前 M-1 位固定 + 剩下 1 个数全排列 return
     */
    private fun permute(fixedNums: List<Int>, nums: List<Int>): List<List<Int>> {
        if (nums.size <= 1) {
            return listOf(fixedNums + nums)
        }
        val result = mutableListOf<List<Int>>()
        for (num in nums) {
            val remainingNums = nums.toMutableList()
            remainingNums.remove(num)
            result.addAll(permute(fixedNums + num, remainingNums))
        }
        return result
    }
}

class Solution46_3 {

    fun permute(nums: IntArray): List<List<Int>> {
        return permuteList(nums.toMutableList())
    }

    fun permuteList(nums: MutableList<Int>): List<MutableList<Int>> {
        if (nums.size == 1) return listOf(mutableListOf(nums.first()))
        val result = mutableListOf<MutableList<Int>>()
        for (num in nums) {
            val subList = nums.toMutableList().apply {
                remove(num)
            }
            permuteList(subList).forEach {
                it.add(0, num)
                result.add(it)
            }
        }
        return result
    }
}

fun main() {
    val permute = Solution46().permute(intArrayOf(1, 2, 3))
    println(permute)
}
