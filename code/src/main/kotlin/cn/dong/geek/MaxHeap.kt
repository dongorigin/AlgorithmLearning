package cn.dong.geek

import cn.dong.util.swap

/**
 * @author dong on 2021/11/26.
 */
class MaxHeap(private val capacity: Int) : Heap {
    init {
        require(capacity > 0) { "capacity must > 0" }
    }

    private val array = IntArray(capacity + 1)

    override var size: Int = 0
        private set

    override val top: Int
        get() = array[1]

    override fun push(item: Int) {
        check(size < capacity) { "exceed capacity" }
        size++
        array[size] = item
        var i = size
        while (i / 2 > 0 && array[i] > array[i / 2]) {
            array.swap(i, i / 2)
            i /= 2
        }
    }

    override fun pop(): Int {
        check(size > 0) { "empty" }

        val top = array[1]
        array[1] = array[size]
        array[size] = 0
        size--

        array.heapify(1, size)
        return top
    }

    override fun toString(): String {
        return array.contentToString()
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
        } else {
            break
        }
    }
}

fun main() {
    val heap = MaxHeap(10)
    heap.push(1)
    heap.push(2)
    heap.push(4)
    heap.push(3)
    heap.push(7)
    heap.push(5)
    println(heap)
    heap.pop()
    println(heap)
    heap.pop()
    println(heap)
}
