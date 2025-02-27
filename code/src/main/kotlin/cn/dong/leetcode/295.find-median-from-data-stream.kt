package cn.dong.leetcode

import java.util.PriorityQueue

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */
class MedianFinder() {
    // 保证下面三点
    // minHeap 存放较大的一半数据，堆顶是最小值
    // maxHeap 存放较小的一半数据，堆顶是最大值
    // 两个堆的数量保持一样，或者 minHeap 多一个。

    // 插入数据时如何保证？
    // 根据数据大小，放到对应堆
    // 再平衡两个堆的大小

    private val minHeap = PriorityQueue<Int>()

    private val maxHeap = PriorityQueue<Int> { o1, o2 ->
        o2.compareTo(o1)
    }

    fun addNum(num: Int) {
        if (minHeap.isEmpty()) {
            // the first item will must be added into minHeap, so the maxHeap is also empty now
            minHeap.add(num)
        } else {
            val min = minHeap.peek()
            if (num >= min) {
                minHeap.add(num)
            } else { // num < min
                maxHeap.add(num)
            }
        }

        // balance, make sure that the size of minHeap is equal to maxHeap, or equal to maxHeap+1
        if (minHeap.size > maxHeap.size + 1) {
            // move item from minHeap to maxHeap
            val item = minHeap.poll()
            maxHeap.add(item)
        } else if (minHeap.size < maxHeap.size) {
            // move item from maxHeap to minHeap
            val item = maxHeap.poll()
            minHeap.add(item)
        }
    }

    fun findMedian(): Double {
        if (minHeap.size == maxHeap.size) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0
        } else { // minSize = maxSize+1
            return minHeap.peek().toDouble()
        }
    }
}
