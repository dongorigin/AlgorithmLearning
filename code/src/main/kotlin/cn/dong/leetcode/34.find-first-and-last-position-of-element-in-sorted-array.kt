package cn.dong.leetcode

/**
 * [34. 在排序数组中查找元素的第一个和最后一个位置 - 力扣（LeetCode）](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array)
 */
class Solution34 {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var left = 0
        var right = nums.size - 1
        val result = intArrayOf(-1, -1)
        while (left <= right) {
            val mid = left + (right - left) / 2
            val midVal = nums[mid]
            if (midVal == target) {
                if (mid > 0 && nums[mid - 1] == target) {
                    right = mid - 1
                } else {
                    result[0] = mid
                    break
                }

            } else if (target > midVal) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        left = 0
        right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            val midVal = nums[mid]
            if (midVal == target) {
                if (mid < nums.size - 1 && target == nums[mid + 1]) {
                    left = mid + 1
                } else {
                    result[1] = mid
                    break
                }
            } else if (target < midVal) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return result
    }
}

fun main() {
    println(Solution34().searchRange(intArrayOf(5,7,7,8,8,10), 8).contentToString())
}