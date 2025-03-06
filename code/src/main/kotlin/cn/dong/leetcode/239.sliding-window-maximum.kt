package cn.dong.leetcode

import io.kotest.matchers.shouldBe

/**
 * [239. 滑动窗口最大值 - 力扣（LeetCode）](https://leetcode-cn.com/problems/sliding-window-maximum/)
 *
 * 需求
 * - 一组数，求最大值
 * - 这组数，删除第一个数，求最大值
 * - 这组数，添加一个数，求最大值
 *
 * 单调队列的性质
 * - 单调递减，队首是最大的。
 * - 添加元素，保持单调递减，添加前移除比当前小的元素。
 * - 删掉队首，队首还是最大的。因为可能已经在添加新元素时被移除了，所以要确认队首是待移除的。
 */
class Solution239 {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val deque = ArrayDeque<Int>() // 队列保持递减，队首是最大的
        val result = IntArray(nums.size - k + 1)
        for (end in nums.indices) {
            // i=end=start+k-1, start=i-k+1
            val start = end - k + 1

            // in
            while (deque.isNotEmpty() && deque.last() < nums[end]) {
                deque.removeLast()
            }
            deque.addLast(nums[end])

            // out
            if (start > 0) {
                if (deque.first() == nums[start - 1]) {
                    deque.removeFirst()
                }
            }

            // update
            if (start >= 0) {
                result[start] = deque.first()
            }
        }
        return result
    }
}

fun main() {
    Solution239().maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3) shouldBe intArrayOf(3, 3, 5, 5, 6, 7)
}
