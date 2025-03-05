package cn.dong.leetcode

/**
 * [303. 区域和检索 - 数组不可变 - 力扣（LeetCode）](https://leetcode.cn/problems/range-sum-query-immutable/)
 *
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */
class NumArray(nums: IntArray) {
    val sumArray = IntArray(nums.size)

    init {
        sumArray[0] = nums[0]
        for (i in 1..nums.size-1) {
            sumArray[i] = sumArray[i-1] + nums[i]
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        val prevSum = if (left == 0) 0 else sumArray[left - 1]
        return sumArray[right] - prevSum
    }

}
