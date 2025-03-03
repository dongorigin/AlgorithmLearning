package cn.dong.leetcode

import kotlin.math.max
import kotlin.math.min

class Solution42 {
    fun trap(height: IntArray): Int {
        val prevMaxArray = IntArray(height.size) // a[i] 表示 i 与左侧的最高值
        val nextMaxArray = IntArray(height.size) // a[i] 表示 i 与右侧的最高值

        prevMaxArray[0] = height[0]
        for (i in 1..height.size-1) {
            prevMaxArray[i] = max(height[i], prevMaxArray[i-1])
        }
        for (i in height.size - 1 downTo 0) {
            val h = height[i]
            val max = if (i == height.size-1) {
                h
            } else {
                max(h, nextMaxArray[i+1])
            }
            nextMaxArray[i] = max
        }

        var sum = 0
        for (i in 0..height.size-1) {
            val result = min(prevMaxArray[i], nextMaxArray[i]) - height[i]
            sum += result
        }
        return sum
    }
}