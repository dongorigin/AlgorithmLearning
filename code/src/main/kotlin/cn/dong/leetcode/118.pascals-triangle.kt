package cn.dong.leetcode

/**
 * [118. 杨辉三角 - 力扣（LeetCode）](https://leetcode.cn/problems/pascals-triangle)
 */
class Solution118 {

    fun generate(numRows: Int): List<List<Int>> {
        val rows = mutableListOf<List<Int>>()
        for (row in 0..numRows - 1) {
            val list = mutableListOf<Int>()
            val size = row + 1
            for (i in 0..size - 1) {
                if (i == 0 || i == size - 1) {
                    list.add(1)
                } else {
                    val lastRow = rows[row - 1]
                    list.add(lastRow[i - 1] + lastRow[i])
                }
            }
            rows.add(list)
        }
        return rows
    }
}