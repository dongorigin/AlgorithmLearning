package cn.dong.leetcode

import java.util.*
import kotlin.test.assertEquals

/**
 * [20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)
 */
class ValidParenthesesChecker {

    private val stack = Stack<Char>()

    private val bracketCloseToOpen = mapOf<Char, Char>(
            ')' to '(',
            '}' to '{',
            ']' to '[')

    fun isValid(s: String): Boolean {
        for (char in s) {
            if (bracketCloseToOpen.containsKey(char)) {
                // is close bracket
                val openBracket = bracketCloseToOpen[char]
                if (stack.isEmpty()
                        || stack.pop() != openBracket) {
                    return false
                }
            } else {
                // is open bracket，题目条件简单只有两种情况
                stack.push(char)
            }
        }
        return stack.isEmpty()
    }
}

fun main() {
    assertEquals(true, ValidParenthesesChecker().isValid(""))
    assertEquals(false, ValidParenthesesChecker().isValid("["))
    assertEquals(false, ValidParenthesesChecker().isValid("]"))
    assertEquals(true, ValidParenthesesChecker().isValid("[]"))
    assertEquals(false, ValidParenthesesChecker().isValid("(]"))
    assertEquals(true, ValidParenthesesChecker().isValid("([])"))
}
