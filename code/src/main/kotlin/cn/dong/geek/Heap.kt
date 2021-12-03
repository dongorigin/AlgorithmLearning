package cn.dong.geek

import cn.dong.util.swap

/**
 * 大顶堆
 *
 * @author dong on 2021/11/26.
 */
class Heap(private val capacity: Int) {

    private val items = IntArray(capacity + 1)
    private var count = 0

    fun insert(item: Int) {
        if (count >= capacity) throw IllegalStateException("count exceed capacity")

        count++
        items[count] = item

        // heapify
        var i = count
        while (i / 2 > 0 && items[i] > items[i / 2]) {
            items.swap(i, i / 2)
            i /= 2
        }
    }

    fun removeTop() {
        if (count < 1) throw IllegalStateException("no item")

        items[1] = items[count]
        items[count] = 0
        count--

        items.heapify(1, count)
    }

    override fun toString(): String {
        return items.contentToString()
    }
}

/** 数组部分堆化 */
fun IntArray.heapify(start: Int, end: Int) {
    var i = start
    while (true) {
        val left = i * 2
        val right = i * 2 + 1
        val maxLeaf = if (right <= end && this[right] > this[left]) {
            right
        } else if (left <= end) {
            left
        } else {
            break
        }

        if (this[i] < this[maxLeaf]) {
            this.swap(i, maxLeaf)
            i = maxLeaf
            continue
        } else {
            break
        }
    }
}

fun main() {
    val heap = Heap(10)
    heap.insert(1)
    heap.insert(2)
    heap.insert(4)
    heap.insert(3)
    heap.insert(7)
    heap.insert(5)
    println(heap)
    heap.removeTop()
    println(heap)
    heap.removeTop()
    println(heap)
}
