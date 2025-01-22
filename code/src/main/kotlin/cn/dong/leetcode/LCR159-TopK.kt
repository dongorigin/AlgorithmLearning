package cn.dong.leetcode

/**
 * [LCR 159. 库存管理 III - 力扣（LeetCode）](https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/)
 * Top K 变形
 */
class SolutionLCR159 {
    fun inventoryManagement(stock: IntArray, cnt: Int): IntArray {
        bottomK(stock, 0, stock.size - 1, cnt)
        // the [0, cnt-1] are smallest K numbers in the list

        // copy to new array
        val result = IntArray(cnt) { i ->
            stock[i]
        }
        return result
    }

    private fun bottomK(array: IntArray, start: Int, end: Int, k: Int) {
        if (start >= end) return // ??

        val pivot = partition(array, start, end)
        if (pivot == k - 1) {
            // [0, pivot] are smallest K numbers
            return
        } else if (pivot > k - 1) {
            // [0, pivot] are smallest numbers, but the count is greater than k, so we need to search in the [start, pivot-1]
            bottomK(array, start, pivot - 1, k)
        } else { // pivot < k-1
            // [0, pivot] are smallest numbers, but the count is less than k, so we need to search in the [pivot+1, end]
            bottomK(array, pivot + 1, end, k)
        }
    }

    /**
     * return the index of pivot
     * [start, pivot-1] less than array[pivot]
     * [pivot+1, end] greater than or equal to array[pivot]
     */
    private fun partition(array: IntArray, start: Int, end: Int): Int {
        val pivot = array[end]

        // [start, i-1] less than pivot
        // [i, end-1] greater than pivot
        var i = start
        for (j in start..end - 1) {
            if (array[j] < pivot) {
                array.swap(i, j)
                i++
            }
        }
        array.swap(i, end)
        return i
    }

    private fun IntArray.swap(i: Int, j: Int) {
        if (i==j ) return
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}