package cn.dong.leetcode

/**
 * [35. 搜索插入位置 - 力扣（LeetCode）](https://leetcode.cn/problems/search-insert-position)
 * 题目要求：求第一个大于等于 target 的位置
 */
class Solution35 {

    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            val midValue = nums[mid]
            if (midValue == target) {
                return mid
            } else if (target > midValue) {
                left = mid + 1
            } else { // target < midVal
                if (mid == 0) { // 比最小值还小
                    return 0
                } else if (target > nums[mid - 1]) { // 比 mid 小，比 mid-1 大
                    return mid
                } else {
                    right = mid - 1
                }
            }
        }
        return nums.size
    }

    fun searchInsert2(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            // nums[left-1] < target
            // nums[right+1] >= target
            // 闭区间 [left, right] 和 target 的大小关系是未知的

            val mid = left + (right - left) / 2
            if (nums[mid] < target) {
                left = mid + 1 // [mid+1, right]
            } else { // >= target
                right = mid - 1 // [left, mid-1]
            }
        }
        return right + 1
    }

}
