package cn.dong.leetcode

import io.kotest.matchers.shouldBe

/**
 * [1552. 两球之间的磁力 - 力扣（LeetCode）](https://leetcode-cn.com/problems/magnetic-force-between-two-balls/)
 *
 * @author dong on 2021/12/16.
 */
class Solution1552 {
    fun maxDistance(position: IntArray, m: Int): Int {
        position.sort()

        var left = 1
        var right = position[position.size - 1]
        var result = left
        while (left <= right) {
            val mid = (left + right) / 2
            if (check(position, m, mid)) {
                result = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return result
    }

    // greedily
    fun check(position: IntArray, m: Int, x: Int): Boolean {
        var prev = 0
        var count = 1
        for (i in 1 until position.size) {
            if (position[i] - position[prev] >= x) {
                count++
                prev = i
            }
        }
        return count >= m
    }

}

fun main() {
    val solution = Solution1552()
    solution.check(intArrayOf(1, 2, 3, 4, 7), 3, 3) shouldBe true
    solution.maxDistance(intArrayOf(1, 2, 3, 4, 7), 3) shouldBe 3
    solution.maxDistance(intArrayOf(5, 4, 3, 2, 1, 1000000000), 2) shouldBe 999999999
}
