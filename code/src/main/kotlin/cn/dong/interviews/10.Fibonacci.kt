package cn.dong.interviews

/**
 * @author dong on 2018/10/03.
 */
fun main(args: Array<String>) {
    println(fibonacci(1))
    println(fibonacci(10))
    println(fibonacci(100))
}

/**
 * 斐波那契数列
 */
fun fibonacci(n: Int): Long {
    if (n == 0) return 0
    if (n == 1) return 1

    var previousTwo = 0L
    var previousOne = 1L
    var current = 0L
    for (i in 2..n) {
        current = previousOne + previousTwo
        previousTwo = previousOne
        previousOne = current
    }
    return current
}
