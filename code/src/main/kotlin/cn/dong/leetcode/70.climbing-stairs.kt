package cn.dong.leetcode

/**
 * [70. 爬楼梯 - 力扣（LeetCode）](https://leetcode.cn/problems/climbing-stairs)
 */
class Solution70 {
    // O(n^2) timeout
    fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2

        return climbStairs(n - 1) + climbStairs(n - 2)
    }


    fun climbStairs2(n: Int): Int {
        val cache = IntArray(n + 1)
        return climb(n, cache)
    }

    private fun climb(n: Int, cache: IntArray): Int {
        if (n == 1) return 1
        if (n == 2) return 2

        if (cache[n] != 0) {
            return cache[n]
        } else {
            val steps = climb(n - 1, cache) + climb(n - 2, cache)
            cache[n] = steps
            return steps
        }
    }


    // f[i]=f[i−1]+f[i−2]
    fun climbStairs3(n: Int): Int {
        if (n == 1) return 1
        val steps = IntArray(n + 1)
        steps[1] = 1
        steps[2] = 2
        for (i in 3..n) {
            steps[i] = steps[i - 1] + steps[i - 2]
        }
        return steps[n]
    }

}