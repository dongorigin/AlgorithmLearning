package cn.dong.leetcode

import kotlin.test.assertEquals
import java.util.*

/**
 * [678. 有效的括号字符串 - 力扣（LeetCode）](https://leetcode-cn.com/problems/valid-parenthesis-string/)
 */
class Solution678 {

    fun checkValidString(s: String): Boolean {
        val openStack = LinkedList<IndexedValue<Char>>()
        val asteriskStack = LinkedList<IndexedValue<Char>>()
        for (indexedChar in s.withIndex()) {
            when (indexedChar.value) {
                '(' -> openStack.push(indexedChar)
                '*' -> asteriskStack.push(indexedChar)
                ')' -> {
                    if (openStack.isNotEmpty()) {
                        openStack.pop()
                    } else if (asteriskStack.isNotEmpty()) {
                        asteriskStack.pop()
                    } else {
                        return false
                    }
                }
                else -> error("char [${indexedChar.value}] not support")
            }
        }

        // 剩余左括号，则 * 需要作为右括号匹配
        while (openStack.isNotEmpty()) {
            val openIndex = openStack.pop().index
            if (asteriskStack.isNotEmpty()) {
                val asteriskIndex = asteriskStack.pop().index
                if (openIndex >= asteriskIndex) {
                    // * 需要在左括号右边
                    return false
                }
            } else {
                return false
            }
        }
        return openStack.isEmpty()
    }
}

fun main() {
    assertEquals(true, Solution678().checkValidString(""))
    assertEquals(true, Solution678().checkValidString("()"))
    assertEquals(true, Solution678().checkValidString("*"))
    assertEquals(true, Solution678().checkValidString("(*"))
    assertEquals(true, Solution678().checkValidString("*)"))
    assertEquals(false, Solution678().checkValidString(")*"))
    assertEquals(true, Solution678().checkValidString("(*)"))
    assertEquals(true, Solution678().checkValidString("(*))"))
    assertEquals(true, Solution678().checkValidString("((*)"))
    assertEquals(true, Solution678().checkValidString("(**)"))
}
