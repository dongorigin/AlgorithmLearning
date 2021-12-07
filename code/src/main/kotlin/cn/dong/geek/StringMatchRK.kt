package cn.dong.geek

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.IsStableType
import io.kotest.datatest.withData
import io.kotest.matchers.ints.shouldBeExactly
import kotlin.math.pow

/**
 * 假设字符串只包含英文字母 a-z
 *
 * @author dong on 2021/12/07.
 */
fun String.findIndexRK(target: String): Int {
    if (target.length > length) return -1
    if (target.isEmpty()) return -1

    val targetH = target.hash()
    var currentH = hash(0, target.length - 1)
    if (currentH == targetH) {
        return 0
    }
    for (i in 1..length - target.length) {
        currentH = currentH * 26 - get(i - 1).hash() * 26.pow(target.length) + get(i + target.length - 1).hash()
        if (currentH == targetH) {
            return i
        }
    }
    return -1
}

private fun Int.pow(x: Int): Int = toFloat().pow(x).toInt()

private fun String.hash(): Int = hash(0, length - 1)

private fun String.hash(start: Int, end: Int): Int {
    require(start >= 0 && end < length && start <= end)
    var sum = 0
    for (i in start..end) {
        sum += get(i).hash() * 26.pow(end - i)
    }
    return sum
}

private fun Char.hash(): Int {
    return this - 'a' + 1
}

private class StringRKTests : FunSpec({

    @IsStableType
    data class CharCase(
        val char: Char,
        val hash: Int,
    )

    context("test Char hash") {
        withData(
            CharCase('a', 1),
            CharCase('b', 2),
            CharCase('z', 26))
        { (char, hash) ->
            char.hash() shouldBeExactly hash
        }
    }

    data class StringCase(
        val str: String,
        val end: Int?,
        val hash: Int,
    )

    context("test String hash") {
        withData(
            StringCase("a", null, 1),
            StringCase("b", null, 2),
            StringCase("ab", null, 28),
            StringCase("ba", null, 53),
            StringCase("ba", 0, 2),
            StringCase("ba", 1, 53),
        ) { (str, end, hash) ->
            val strHash = if (end != null) {
                str.hash(0, end)
            } else {
                str.hash()
            }
            strHash shouldBeExactly hash
        }
    }

    context("test String Match by RK") {
        withData(stringMatchCases) { (source, target, index) ->
            source.findIndexRK(target) shouldBeExactly index
        }
    }
})
