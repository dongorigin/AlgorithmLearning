package cn.dong.leetcode

import io.kotest.matchers.shouldBe
import java.util.*

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
 * - 删掉队首，队首还是最大的。因为可能已经在添加新元素时被移除了，所以要确认队首是待移除的。所以存下标更直观。但存下标作为独立数据结构很奇怪
 *
 * 使用 [ArrayDeque] 时速度慢，无法通过用例，很奇怪，ArrayDeque 是用循环队列实现的，应该也是 O(1)，和 [LinkedList] 无区别才对
 *
 * @author dong on 2022/01/01.
 */
class Solution239 {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val result = IntArray(nums.size - k + 1)
        val indexDeque: Deque<Int> = LinkedList() // index 递增，nums[index] 递减

        val push: (index: Int) -> Unit = {
            while (indexDeque.isNotEmpty() && nums[indexDeque.last()] < nums[it]) {
                indexDeque.removeLast()
            }
            indexDeque.addLast(it)
        }

        for (i in 0..k - 2) {
            push(i)
        }

        for (start in 0..nums.size - k) {
            // window start
            while (indexDeque.isNotEmpty() && indexDeque.first() < start) {
                indexDeque.removeFirst()
            }

            // window end
            val end = start + k - 1
            push(end)

            result[start] = nums[indexDeque.first()]
        }
        return result
    }
}

fun main() {
    Solution239().maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3) shouldBe intArrayOf(3, 3, 5, 5, 6, 7)
}
