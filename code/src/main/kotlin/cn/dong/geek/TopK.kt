package cn.dong.geek

import cn.dong.util.swap

/**
 * 1.通用？
 * 2.专用？
 * - 没满就加入
 * - 满了再对比
 *
 * @author dong on 2021/12/03.
 */
fun IntArray.topK(k: Int): IntArray {
    if (k <= 0) return IntArray(0)

    val minHeap = MinHeap(k)
    for (i in this) {
        if (minHeap.count < k) {
            minHeap.insert(i)
        } else {
            if (i > minHeap.min) {
                minHeap.replaceTop(i)
            }
        }
    }
    return minHeap.all()
}

class MinHeap(private val size: Int) {
    init {
        require(size > 0) { "size must > 0" }
    }

    private val array = IntArray(size + 1)

    var count = 0
        private set

    val min: Int
        get() = array[1]

    fun insert(item: Int) {
        check(count <= size)

        count++
        array[count] = item

        // heapify
        var i = count
        while (i / 2 > 0 && array[i / 2] > array[i]) {
            array.swap(i, i / 2)
            i /= 2
        }
    }

    fun replaceTop(item: Int) {
        array[1] = item

        var i = 1
        while (true) {
            val left = i * 2
            val right = i * 2 + 1
            val minLeaf = if (right <= count && array[right] < array[left]) {
                right
            } else if (left <= count) {
                left
            } else {
                break
            }
            array.swap(i, minLeaf)
            i = minLeaf
        }
    }

    fun all(): IntArray {
        return array.drop(1).toIntArray()
    }
}

fun main() {
    intArrayOf(1, 2, 3, 4, 5).topK(2).print()
    intArrayOf(1, 1, 1, 1, 1).topK(2).print()
    intArrayOf(5, 4, 3, 2, 1).topK(2).print()
    intArrayOf(4, 3, 5, 1, 2).topK(2).print()
}

private fun IntArray.print() {
    println(this.contentToString())
}
