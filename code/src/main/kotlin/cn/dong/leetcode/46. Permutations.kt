package cn.dong.leetcode

/**
 * [46. 全排列 - 力扣（LeetCode）](https://leetcode-cn.com/problems/permutations/)
 *
 * @author dong on 2020/08/09.
 */
class Permutations {
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

fun main() {
    val permute = Permutations().permute(intArrayOf(1, 2, 3))
    print(permute)
}
