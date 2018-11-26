package cn.dong.interviews

/**
 * @author dong on 2018/11/26.
 */
fun findGreatestSumOfSubarray(input: IntArray): Int? {
    if (input.isEmpty()) {
        return null
    }
    var sum = 0
    var max = Int.MIN_VALUE
    for (i in input) {
        if (sum < 0) {
            sum = i
        } else {
            sum += i
        }
        if (max < sum) {
            max = sum
        }
    }
    return max
}

fun main(args: Array<String>) {
    println(findGreatestSumOfSubarray(intArrayOf(1, -2, 3, 10, -4, 7, 2, -5)))
    println(findGreatestSumOfSubarray(intArrayOf(1, 4, 0, 5)))
    println(findGreatestSumOfSubarray(intArrayOf(-3, -1, -5)))
    println(findGreatestSumOfSubarray(intArrayOf()))
}
