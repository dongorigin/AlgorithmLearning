package cn.dong.geektime

import kotlin.test.assertEquals

// [16 | 二分查找（下）：如何快速定位IP对应的省份地址？-数据结构与算法之美-极客时间](https://time.geekbang.org/column/article/42733)
/**
 * 查找第一个值等于给定值的元素的 Index
 */
fun searchFirst(array: IntArray, target: Int): Int {
    var low = 0
    var high = array.size - 1
    while (low <= high) {
        val mid = low + (high - low) / 2
        val midVal = array[mid]
        if (target == midVal) {
            if (mid > 0 && target == array[mid - 1]) {
                high = mid - 1
            } else {
                return mid
            }
        } else if (target < midVal) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return -1
}

/**
 * 查找最后一个值等于给定值的元素
 */
fun searchLast(array: IntArray, target: Int): Int {
    var low = 0
    var high = array.size - 1

    while (low <= high) {
        var mid = low + (high - low) / 2
        var midVal = array[mid]
        if (midVal == target) {
            if (mid < array.size - 1 && target == array[mid + 1]) {
                low = mid + 1
            } else {
                return mid
            }
        } else if (target < midVal) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return -1
}

/**
 * 找第一个大于等于给定值的元素
 */
fun searchFirstGreaterOrEqual(array: IntArray, target: Int): Int {
    var low = 0
    var high = array.size - 1
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (array[mid] < target) {
            low = mid + 1
        } else { // array[mid] >= target
            if (mid > 0 && array[mid - 1] >= target) {
                high = mid - 1
            } else {
                return mid
            }
        }
    }
    return -1
}

/**
 * 查找最后一个小于等于给定值的元素
 */
fun searchLastLessOrEqual(array: IntArray, target: Int): Int {
    var low = 0
    var high = array.size - 1
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (array[mid] > target) {
            high = mid - 1
        } else { // array[mid] <= target
            if (mid < array.size - 1 && array[mid + 1] <= target) {
                low = mid + 1
            } else {
                return mid
            }
        }
    }
    return -1
}

fun main() {
    val array = intArrayOf(1, 3, 4, 4, 4, 4, 6, 7, 8)
    assertEquals(2, searchFirst(array, 4))
    assertEquals(0, searchFirst(array, 1))
    assertEquals(5, searchLast(array, 4))

    assertEquals(6, searchFirstGreaterOrEqual(array, 5))
    assertEquals(2, searchFirstGreaterOrEqual(array, 4))
    assertEquals(1, searchFirstGreaterOrEqual(array, 2))
    assertEquals(-1, searchFirstGreaterOrEqual(array, 9))

    assertEquals(8, searchLastLessOrEqual(array, 9))
    assertEquals(-1, searchLastLessOrEqual(array, 0))
    assertEquals(5, searchLastLessOrEqual(array, 4))
    assertEquals(5, searchLastLessOrEqual(array, 5))

}