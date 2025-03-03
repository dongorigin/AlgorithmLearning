package cn.dong.leetcode

import kotlin.math.max
import kotlin.math.min

/**
 * [11. 盛最多水的容器 - 力扣（LeetCode）](https://leetcode.cn/problems/container-with-most-water)
 */
class Solution11 {

    // O(n)
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size- 1
        var max = 0

        while (left < right) {
            val minHeight = min(height[left], height[right])
            val width = right - left
            val area = minHeight * width
            max = max(max, area)
            if (height[left] == height[right]) {
                left++
                right--
            } else if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }
        return max
    }

    // O(n^2)
    fun maxArea2(height: IntArray): Int {
        var max = 0
        for (start in 0..height.size - 2) {
            for (end in start + 1..height.size - 1) {
                val minHeight = min(height[start], height[end])
                val width = end - start
                val x = width * minHeight
                if (x > max) {
                    max = x
                }
            }
        }
        return max
    }


}