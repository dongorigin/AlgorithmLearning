package cn.dong.geektime

import io.kotest.matchers.shouldBe

/**
 * '?'匹配零个或一个任意字符
 * '*'匹配零个或多个任意字符
 *
 * @author dong on 2021/12/11.
 */
class Pattern(private val pattern: String) {

    fun match(target: String): Boolean {
        val charArray = target.toCharArray()
        return innerMatch(charArray, 0, 0)
    }

    private fun innerMatch(target: CharArray, targetIndex: Int, patternIndex: Int): Boolean {
        if (patternIndex == pattern.length) {
            return targetIndex == target.size
        }
        return when (pattern[patternIndex]) {
            '?' -> innerMatch(target, targetIndex, patternIndex + 1) // 零个字符
                    || innerMatch(target, targetIndex + 1, patternIndex + 1) // 一个任意字符
            '*' -> (targetIndex..target.size).any { innerMatch(target, it, patternIndex + 1) }
            target.getOrNull(targetIndex) -> innerMatch(target, targetIndex + 1, patternIndex + 1)
            else -> false
        }
    }
}

fun main() {
    Pattern("?").match("") shouldBe true
    Pattern("?").match("a") shouldBe true
    Pattern("?").match("ab") shouldBe false
    Pattern("a?").match("a") shouldBe true
    Pattern("a?").match("ab") shouldBe true
    Pattern("a?c").match("ac") shouldBe true
    Pattern("a?c").match("abc") shouldBe true
    Pattern("*").match("") shouldBe true
    Pattern("*").match(" ") shouldBe true
    Pattern("*").match("ab") shouldBe true
    Pattern("a*").match("ab") shouldBe true
    Pattern("?a*").match("a") shouldBe true
    Pattern("?a*").match("ba") shouldBe true
    Pattern("?a*").match("ab") shouldBe true
    Pattern("?a*").match("b") shouldBe false
}
