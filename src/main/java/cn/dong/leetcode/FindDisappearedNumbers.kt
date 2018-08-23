package cn.dong.leetcode

import org.junit.Test

/**
 * Source: 448 https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 *
 * Other people's solution: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/discuss/92956/Java-accepted-simple-solution
 * 通过负数标记元素存在，最后查一遍标记，非负数的位置都是不存在的
 *
 * @author dong on 2018/08/23.
 */
class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        var index = 0
        while (index < nums.size) {
            val num = nums[index]
            if (num == 0) {
                index++
                continue
            }
            if (num != index + 1) {
                if (num != nums[num - 1]) {
                    nums.swap(index, num - 1)
                } else {
                    nums[index] = 0
                    index++
                }
            } else {
                index++
            }
        }
        val result = mutableListOf<Int>()
        nums.forEachIndexed { index, i ->
            if (i == 0) {
                result.add(index + 1)
            }
        }
        return result
    }

    fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}

@Test
fun main(args: Array<String>) {
    val input = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
    val output = Solution().findDisappearedNumbers(input)
    println(output)
}