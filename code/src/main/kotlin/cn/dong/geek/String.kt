package cn.dong.geek

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

fun String.findIndexRK(target: String) {

}

private data class FindData(
    val source: String,
    val target: String,
    val index: Int,
)

private class FindTests : FunSpec({
    context("test BR") {
        withData(
            FindData("a", "", -1),
            FindData("", "a", -1),
            FindData("abc", "abcd", -1),
            FindData("abcde", "abcde", 0),
            FindData("abcde", "cd", 2),
        ) { (source, target, index) ->
            source.findIndexBR(target) shouldBeExactly index
        }
    }
})
