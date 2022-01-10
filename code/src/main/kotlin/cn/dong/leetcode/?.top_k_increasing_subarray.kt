package cn.dong.leetcode

import io.kotest.matchers.shouldBe
import java.util.*

/**
 * 一个数组，找出前 K 个最长的升序子数组，按长度降序返回。
 * 比如 [5,2,4,1,3,5]，最长升序子数组是 [1，2，4]
 *
 * 心得：遍历数组，最好按下标从 0 到 size-1 依次，在遍历中处理边界条件，否则容易漏边界。
 *
 * @author dong on 2022/01/10.
 */
class SolutionK {
    private data class Data(
        val endIndex: Int,
        val size: Int
    ) : Comparable<Data> {
        override fun compareTo(other: Data): Int = size.compareTo(other.size)
    }

    fun topK(nums: IntArray, k: Int): Array<IntArray> {
        var size = 0
        val heap = PriorityQueue<Data>() // 小顶堆，为了求 topK，每次比较当前 topK 中最小的
        for (i in 0..nums.size - 1) {
            size++
            if (nums.size == 1) {
                if (k > 0) {
                    heap.add(Data(i, size))
                }
            } else if (i == nums.size - 1 || nums[i + 1] < nums[i]) {
                if (heap.size < k) {
                    heap.add(Data(i, size))
                } else {
                    if (size > heap.peek().size) {
                        heap.poll()
                        heap.add(Data(i, size))
                    }
                }
                size = 0
            }
        }

        val emptyArray = IntArray(0)
        val result = Array(heap.size) { emptyArray }
        for (i in heap.size - 1 downTo 0) {
            val (endIndex, size) = heap.poll()
            val array = IntArray(size)
            for (j in 0..size - 1) {
                array[j] = nums[endIndex - size + 1 + j]
            }
            result[i] = array
        }
        return result
    }
}

fun main() {
    SolutionK().topK(intArrayOf(), 1) shouldBe emptyArray()
    SolutionK().topK(intArrayOf(1), 2) shouldBe arrayOf(intArrayOf(1))
    SolutionK().topK(intArrayOf(1), 0) shouldBe emptyArray()
    SolutionK().topK(intArrayOf(8, 9, 2, 4, 5, 1, 3, 5, 9), 2) shouldBe
            arrayOf(intArrayOf(1, 3, 5, 9), intArrayOf(2, 4, 5))
}
