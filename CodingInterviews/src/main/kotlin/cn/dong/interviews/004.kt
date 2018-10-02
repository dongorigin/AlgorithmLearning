package cn.dong.interviews

/**
 * 二维数组查找
 *
 * @author dong on 2018/10/02.
 */
fun main(args: Array<String>) {
    val row1 = intArrayOf(1, 2, 8, 9)
    val row2 = intArrayOf(2, 4, 9, 12)
    val row3 = intArrayOf(4, 7, 10, 13)
    val row4 = intArrayOf(6, 8, 11, 15)
    val numbers = arrayOf(row1, row2, row3, row4)

    check(search(numbers, 7)) // hit
    check(!search(numbers, 5)) // min < x < max
    check(!search(numbers, 0)) // < min
    check(!search(numbers, 16)) // > max
}

fun search(numbers: Array<IntArray>, target: Int): Boolean {
    // 从左下角开始查找
    var row = numbers.size - 1
    var col = 0
    while (row >= 0 && col < numbers[0].size) {
        when {
            target < numbers[row][col] -> row--
            target > numbers[row][col] -> col++
            else -> return true
        }
    }
    return false
}
