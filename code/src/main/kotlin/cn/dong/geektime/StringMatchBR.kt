package cn.dong.geektime

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.ints.shouldBeExactly

/**
 * @author dong on 2021/12/04.
 */
fun String.findIndexBR(target: String): Int {
    if (target.length > length) return -1
    if (target.isEmpty()) return -1

    for (i in 0..length - target.length) {
        var j = 0
        while (j < target.length) {
            if (this[i + j] == target[j]) {
                j++
            } else {
                break
            }
        }
        if (j == target.length) {
            return i
        }
    }
    return -1
}

data class StringMatchCase(
    val source: String,
    val target: String,
    val index: Int,
)

val stringMatchCases = listOf(
    StringMatchCase("a", "", -1),
    StringMatchCase("", "a", -1),
    StringMatchCase("abc", "abcd", -1),
    StringMatchCase("abcde", "abcde", 0),
    StringMatchCase("abcde", "cd", 2),
    StringMatchCase("abcdefghijkabc", "kab", 10),
)

private class StringBRTests : FunSpec({

    context("test String Match by BR") {
        withData(stringMatchCases) { (source, target, index) ->
            source.findIndexBR(target) shouldBeExactly index
        }
    }
})
