package cn.dong.geektime

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.IsStableType
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldContainExactly
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
    if (k <= 0) return IntArray(0)

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

@IsStableType
private data class TopKData(
    val a: IntArray,
    val k: Int,
    val topK: IntArray
)

private class TopKTests : FunSpec({

    val cases = listOf(
        TopKData(intArrayOf(), 3, intArrayOf()),
        TopKData(intArrayOf(1, 2, 3), 0, intArrayOf()),
        TopKData(intArrayOf(1, 2, 3), -1, intArrayOf()),
        TopKData(intArrayOf(1, 2, 3), 1, intArrayOf(3)),
        TopKData(intArrayOf(1, 2, 3), 5, intArrayOf(1, 2, 3)),
        TopKData(intArrayOf(1, 2, 3, 4, 5), 3, intArrayOf(3, 4, 5)),
    )

    context("test topK") {
        withData(cases) { (array, k, topK) ->
            array.topK(k).toTypedArray() shouldContainExactly topK.toTypedArray()
        }
    }
    context("test topK2") {
        withData(cases) { (array, k, topK) ->
            array.topK2(k).toTypedArray() shouldContainExactly topK.toTypedArray()
        }
    }
})
