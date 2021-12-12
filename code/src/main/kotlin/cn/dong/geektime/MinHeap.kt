package cn.dong.geektime

import cn.dong.util.swap

/**
 * @author dong on 2021/12/03.
 */
class MinHeap(private val capacity: Int) : Heap {
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
        while (i / 2 > 0 && array[i / 2] > array[i]) {
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

        var i = 1
        while (true) {
            val left = i * 2
            val right = i * 2 + 1
            val minLeaf = if (right <= size && array[right] < array[left]) {
                right
            } else if (left <= size) {
                left
            } else {
                break
            }
            if (array[i] > array[minLeaf]) {
                array.swap(i, minLeaf)
                i = minLeaf
            } else {
                break
            }
        }

        return top
    }
}
