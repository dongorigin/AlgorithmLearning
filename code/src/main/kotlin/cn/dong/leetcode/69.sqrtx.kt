package cn.dong.leetcode

import io.kotest.matchers.shouldBe

/**
 * x 平方根的整数部分 ans 是满足 k^2 ≤ x 的最大 k 值
 * 比如 x=8，2^2=4，3^2=9，所以 k = 2
 *
 * @author dong on 2021/12/21.
 */
class Solution69 {
    fun mySqrt(x: Int): Int {
        var result = 0
        var low = 0
        var high = x
        while (low <= high) {
            val mid = low + (high - low) / 2
            val mPower = mid.toLong() * mid
            if (mPower <= x) {
                result = mid
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        return result
    }
}

fun main() {
    Solution69().mySqrt(0) shouldBe 0
    Solution69().mySqrt(1) shouldBe 1
    Solution69().mySqrt(2147395599) shouldBe 46339
}
