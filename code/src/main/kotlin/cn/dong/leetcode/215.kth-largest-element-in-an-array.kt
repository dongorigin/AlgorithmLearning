package cn.dong.leetcode

import java.util.*

/**
 * [215. 数组中的第K个最大元素 - 力扣（LeetCode）](https://leetcode.cn/problems/kth-largest-element-in-an-array)
 */
class Solution215 {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val heap = PriorityQueue<Int>() // 小顶堆
        for (num in nums) {
            if (heap.size < k) {
                heap.add(num)
            } else { // size == k
                if (num > heap.peek()) {// 大于k个中最小的
                    heap.poll()
                    heap.add(num)
                }
            }
        }
        return heap.peek()
    }
}