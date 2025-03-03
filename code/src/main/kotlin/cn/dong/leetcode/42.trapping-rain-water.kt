package cn.dong.leetcode

import kotlin.math.max
import kotlin.math.min

/**
 * [42. 接雨水 - 力扣（LeetCode）](https://leetcode.cn/problems/trapping-rain-water)
 */
class Solution42 {
    fun trap(height: IntArray): Int {
        val leftMaxHeightArray = IntArray(height.size) // a[i] 表示位置 i 及其左侧的最高值
        val rightMaxHeightArray = IntArray(height.size) // a[i] 表示位置 i 及其右侧的最高值

        leftMaxHeightArray[0] = height[0]
        for (i in 1..height.size - 1) {
            leftMaxHeightArray[i] = max(height[i], leftMaxHeightArray[i - 1])
        }

        rightMaxHeightArray[height.size - 1] = height[height.size - 1]
        for (i in height.size - 2 downTo 0) {
            val max = max(height[i], rightMaxHeightArray[i + 1])
            rightMaxHeightArray[i] = max
        }

        var sum = 0
        for (i in 0..height.size - 1) {
            val result = min(leftMaxHeightArray[i], rightMaxHeightArray[i]) - height[i]
            sum += result
        }
        return sum
    }

    fun trap2(height: IntArray): Int {
        var left = 0
        var right = height.size - 1

        var leftMaxH = 0 // 位置 left 和其左侧的最高值
        var rightMaxH = 0 // 位置 right 和其右侧的最高值

        var sum = 0
        while (left <= right) { // left == right 时，需要计算当前位置的雨水
            leftMaxH = max(leftMaxH, height[left])
            rightMaxH = max(rightMaxH, height[right])
            if(leftMaxH <= rightMaxH) { // 接水量由短板确定，左侧是短板
                sum += leftMaxH - height[left]
                left++
            } else {
                sum += rightMaxH - height[right]
                right--
            }
        }
        return sum
    }
}

fun main() {
    val height = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
    println(Solution42().trap2(height))
}
