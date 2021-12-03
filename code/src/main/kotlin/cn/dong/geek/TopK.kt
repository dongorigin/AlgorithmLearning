package cn.dong.geek

import java.util.*

/**
 * @author dong on 2021/12/03.
 */
fun IntArray.topK(k: Int): IntArray {
    if (k <= 0) return IntArray(0)

    val minHeap = MinHeap(k)
    for (i in this) {
        if (minHeap.size < k) {
            minHeap.push(i)
        } else {
            if (i > minHeap.top) {
                minHeap.pop()
                minHeap.push(i)
            }
        }
    }

    val result = IntArray(minHeap.size)
    for (i in 0 until minHeap.size) {
        result[i] = minHeap.pop()
    }
    return result
}

fun IntArray.topK2(k: Int): IntArray {
    val priorityQueue = PriorityQueue<Int>(k)
    for (i in this) {
        if (priorityQueue.size < k) {
            priorityQueue.offer(i)
        } else {
            if (i > priorityQueue.peek()) {
                priorityQueue.poll()
                priorityQueue.offer(i)
            }
        }
    }
    return priorityQueue.toIntArray()
}

fun main() {
    intArrayOf(1, 2, 3, 4, 5).topK2(3).print()
    intArrayOf(1, 1, 1, 1, 1).topK2(3).print()
    intArrayOf(5, 4, 3, 2, 1).topK2(3).print()
    intArrayOf(4, 3, 5, 1, 2).topK2(3).print()
}

private fun IntArray.print() {
    println(this.contentToString())
}
