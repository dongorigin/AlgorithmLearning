package cn.dong.leetcode

/**
 * [LCR 159. 库存管理 III - 力扣（LeetCode）](https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/)
 * Top K 变形
 */
class SolutionLCR159 {
    fun inventoryManagement(stock: IntArray, cnt: Int): IntArray {

        var start = 0
        var end = stock.size - 1
        while (true) {
            val pivotIndex = partition(stock, start, end)
            if (pivotIndex == cnt) {
                // [0, index-1]
                return stock.sliceArray(0..pivotIndex - 1)
            } else if (pivotIndex + 1 == cnt) {
                // [0, index]
                return stock.sliceArray(0..pivotIndex)
            } else if (pivotIndex > cnt) {
                end = pivotIndex - 1
            } else { // pivotIndex < cnt
                start = pivotIndex + 1
            }
        }
    }

    /**
     * after partition, there are three ranges:
     * - [start, m-1]: less than or equal to pivot
     * - m: it is pivot
     * - [m+1, end]: greater than pivot
     *
     * return index of pivot
     */
    fun partition(array: IntArray, start: Int, end: Int): Int {
        val pivot = array[end]
        var i = start
        // range [start, i-1] are less than pivot
        for (j in start..end - 1) {
            if (array[j] <= pivot) {
                array.swap(i, j)
                i++
            }
        }
        array.swap(i, end)
        return i
    }

    fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}