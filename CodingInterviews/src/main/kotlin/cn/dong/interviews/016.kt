package cn.dong.interviews

import kotlin.test.assertEquals

/**
 * raises this value to the integer power [n]
 *
 * @author dong on 2018/10/05.
 */
fun Double.power(n: Int): Double {
    if (this == 0.0 && n < 0) { // Node: Double require [equals], and [==] is same to [equals] in Kotlin
        return Double.POSITIVE_INFINITY
    }
    var result = powerWithNonNegative(n.abs())
    if (n < 0) {
        result = 1 / result
    }
    return result
}

private fun Int.abs(): Int = if (this < 0) -this else this

private fun Double.powerWithNonNegative(exponent: Int): Double {
    require(exponent >= 0)
    var result = 1.0
    var i = exponent
    while (i > 0) {
        result *= this
        i--
    }
    return result
}

fun main(args: Array<String>) {
    assertEquals(1.0, 2.0.power(0))
    assertEquals(2.0, 2.0.power(1))
    assertEquals(16.0, 2.0.power(4))
    assertEquals(1024.0, 2.0.power(10))
    assertEquals(0.25, 2.0.power(-2))

    assertEquals(1.0, 0.0.power(0))
    assertEquals(0.0, 0.0.power(2))
    assertEquals(Double.POSITIVE_INFINITY, 0.0.power(-1))
}
