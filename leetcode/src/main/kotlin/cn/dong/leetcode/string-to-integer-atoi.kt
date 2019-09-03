package cn.dong.leetcode;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 *
 * @author dong on 2019/09/04.
 */
fun myAtoi(str: String): Int {
    val str = str.trim()
    if (str.isEmpty()) return 0

    var index = 0
    var result = 0L
    val sign = when (str[index]) {
        '-' -> {
            index++
            -1
        }
        '+' -> {
            index++
            1
        }
        else -> 1
    }

    while (index < str.length) {
        val char = str[index]
        if (char.isDigit()) {
            val num = char - '0'
            result = result * 10 + num
            if (sign == 1 && result >= Int.MAX_VALUE) {
                return Int.MAX_VALUE
            } else if (sign == -1 && -result <= Int.MIN_VALUE) {
                return Int.MIN_VALUE
            }
            index++
        } else {
            break // 返回当前数字，已存在则返回，不存在则 0
        }
    }
    return (result * sign).toInt()
}
