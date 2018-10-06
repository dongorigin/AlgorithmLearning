package cn.dong.interviews

/**
 * n & flag == flag: 可判断 flag 是否存在
 *
 * @author dong on 2018/10/05.
 */
fun numberOf1(n: Int): Int {
    var count = 0
    var flag = 1
    while (flag > 0) {
        if (n and flag == flag) {
            count++
        }
        flag = flag shl 1
    }
    return count
}

/**
 * i   = 0x1100
 * i-1 = 0x1011
 * and = 0x1000
 * (i-1) & i 相当于 i 最后一位从 1 变 0
 */
fun numberOf1_2(n: Int): Int {
    var count = 0
    var i = n
    while (i > 0) {
        i = (i - 1) and i
        count++
    }
    return count
}

fun main(args: Array<String>) {
    println(numberOf1(0))

    println(numberOf1(0x1001))

    println(numberOf1(1))
    println(numberOf1(Int.MAX_VALUE))

    println(numberOf1(-1))
    println(numberOf1(Int.MIN_VALUE))
}
