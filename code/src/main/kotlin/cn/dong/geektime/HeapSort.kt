package cn.dong.geektime

import cn.dong.util.swap

/**
 * @author dong on 2021/12/01.
 */

/** 数组从下标 1 开始 */
private fun IntArray.heapSort() {
    // heapify
    val end = size - 1
    for (i in end / 2 downTo 1) {
        this.heapify(i, end)
    }

    // sort
    for (i in end downTo 1) {
        this.swap(1, i)
        this.heapify(1, i - 1)
    }
}

private fun testHeapSort() {
    val array = intArrayOf(0, 5, 3, 6, 8, 2, 7, 5, 10)
    array.heapSort()
    println(array.contentToString())
}

fun main() {
    testHeapSort()
}