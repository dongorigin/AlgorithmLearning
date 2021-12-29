package cn.dong.leetcode

import io.kotest.matchers.shouldBe

/**
 * [202. 快乐数 - 力扣（LeetCode）](https://leetcode-cn.com/problems/happy-number/)
 *
 * @author dong on 2021/12/29.
 */
class Solution202 {
    fun isHappy(n: Int): Boolean {
        val set = mutableSetOf<Int>()
        var i = n
        while (true) {
            i = next(i)
            if (i == 1) {
                return true
            } else if (set.contains(i)) {
                return false
            } else {
                set.add(i)
            }
        }
        return false
    }

    fun next(n: Int) : Int {
        var num = n
        var sum = 0
        while (num > 0) {
            val last = num % 10
            sum = sum + last * last
            num = num / 10
        }
        return sum
    }
}

fun main() {
    Solution202().next(19) shouldBe 82
    Solution202().isHappy(19) shouldBe true
}