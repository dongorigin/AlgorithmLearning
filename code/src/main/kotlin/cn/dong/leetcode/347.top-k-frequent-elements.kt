package cn.dong.leetcode

import java.util.*

/**
 * [347. 前 K 个高频元素 - 力扣（LeetCode）](https://leetcode-cn.com/problems/top-k-frequent-elements/)
 * @author dong on 2022/01/02.
 */
class Solution347 {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val numToCount = mutableMapOf<Int, Int>()

        for (num in nums) {
            numToCount[num] = numToCount.getOrDefault(num, 0) + 1
        }

        val pq = PriorityQueue<Data>() // 默认从小到大

        for ((num, count) in numToCount) {
            if (pq.size < k) {
                pq.offer(Data(num, count))
            } else {
                if (count > pq.peek().count) {
                    pq.poll()
                    pq.offer(Data(num, count))
                }
            }
        }
        return pq.map { it.num }.toIntArray()
    }

    private class Data(
        val num: Int,
        val count: Int
    ) : Comparable<Data> {

        override fun compareTo(other: Data): Int {
            return count.compareTo(other.count)
        }
    }
}
