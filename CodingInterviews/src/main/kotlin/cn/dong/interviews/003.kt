package cn.dong.interviews

/**
 * 数组中重复的数字
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *
 * @author dong on 2018/10/01.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(2, 3, 1, 0, 2, 5)
    val result = duplicate(input)
    check(result == true)
}

fun duplicate(numbers: IntArray): Boolean {
    // 重排将每个数 i 移动到 numbers[i]，如果冲突则有重复
    numbers.forEachIndexed { index, i ->
        while (numbers[index] != index) {
            if (numbers[numbers[index]] == numbers[index]) {
                return true
            } else {
                numbers.swap(index, numbers[index])
            }

        }
    }
    return false
}

fun IntArray.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}
