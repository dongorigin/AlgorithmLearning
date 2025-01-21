package cn.dong.leetcode

class Solution912 {
    fun sortArray(nums: IntArray): IntArray {
        quickSort(nums, 0, nums.size - 1)
        return nums
    }

    fun quickSort(nums: IntArray, start: Int, end: Int) {
        if (start >= end) return

        val pivot = partition(nums, start, end)
        quickSort(nums, start, pivot - 1)
        quickSort(nums, pivot + 1, end)
    }

    /**
     * return index of pivot in this array
     */
    fun partition(array: IntArray, start: Int, end: Int): Int {
        val pivot = array[end]

        var i = start // smaller range [start,i-1], larger range [i, end-1]
        for (j in start..end - 1) {
            if (array[j] < pivot) {
                array.swap(i, j)
                i++
            }
        }
        array.swap(i, end)
        return i
    }

    fun IntArray.swap(i: Int, j: Int) {
        if (i == j) return
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}

fun main() {
    val array = intArrayOf(-1, 2, -8, -10)
    Solution912().sortArray(array)
    println(array.joinToString())
}
