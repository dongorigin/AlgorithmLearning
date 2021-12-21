package cn.dong.leetcode

/**
 * [704. 二分查找 - 力扣（LeetCode）](https://leetcode-cn.com/problems/binary-search/)
 *
 * @author dong on 2021/12/21.
 */
class Solution704 {
    // [low, high]
    fun search(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size - 1
        while (low <= high) {
            val mid = low + (high - low) / 2
            val midVal = nums[mid]
            if (midVal == target) {
                return mid
            } else if (target > midVal) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        return -1
    }
}
