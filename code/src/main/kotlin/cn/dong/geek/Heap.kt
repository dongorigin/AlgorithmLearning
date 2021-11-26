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
        if (count >= capacity) throw IllegalStateException("")
        count++
        items[count] = item

        // heapify
        var i = count
        while (i / 2 > 0 && items[i] > items[i / 2]) {
            items.swap(i, i / 2)
            i /= 2
        }
    }

    override fun toString(): String {
        return items.contentToString()
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
}
