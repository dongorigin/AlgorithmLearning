package cn.dong.leetcode

/**
 * [283. 移动零 - 力扣（LeetCode）](https://leetcode.cn/problems/move-zeroes)
 */
class Solution_283 {
    fun moveZeroes(nums: IntArray): Unit {
        var zeroIndex = 0 // the index of first zero
        var numIndex = 0 // the index of first non-zero number after zero

        while (zeroIndex < nums.size) {
            if (nums[zeroIndex] != 0) {
                zeroIndex++
            } else {
                break
            }
        }
        if (zeroIndex >= nums.size) {
            // there is no zero in this array
            return
        }

        numIndex = zeroIndex + 1
        while (numIndex < nums.size) {
            if (nums[numIndex] == 0) {
                numIndex++
            } else {
                nums.swap(zeroIndex, numIndex)
                zeroIndex++
                numIndex++
            }
        }
    }

    fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}