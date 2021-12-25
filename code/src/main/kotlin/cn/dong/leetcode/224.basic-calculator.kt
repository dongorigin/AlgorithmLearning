package cn.dong.leetcode

import io.kotest.matchers.shouldBe
import java.util.*

/**
 * [224. 基本计算器 - 力扣（LeetCode）](https://leetcode-cn.com/problems/basic-calculator/)
 *
 * @author dong on 2021/12/25.
 */
class Solution224 {
    private val nums = Stack<Long>()
    private val ops = Stack<Char>() // only ( + -

    fun calculate(s: String): Int {
        nums.clear()
        ops.clear()

        nums.push(0)
        var i = 0
        val input = s.filterNot { it.isWhitespace() }
        while (i < input.length) {
            val char = input[i]
            if (char.isDigit()) {
                var num = 0L
                while (i < input.length && input[i].isDigit()) {
                    num = num * 10 + input[i].digitToInt()
                    i++
                }
                nums.push(num)
            } else {
                when (char) {
                    '(' -> {
                        ops.push(char)
                        // 1+(-2)
                        if (i + 1 < input.length && input[i + 1] == '+' || input[i + 1] == '-') {
                            nums.push(0)
                        }
                    }
                    ')' -> {
                        while (ops.isNotEmpty()) {
                            val op = ops.peek()
                            if (op == '(') {
                                ops.pop()
                                break
                            } else {
                                cal()
                            }
                        }
                    }
                    '+', '-' -> {
                        cal()
                        ops.push(char)
                    }
                    else -> throw IllegalArgumentException("char[$char] is not supported")
                }
                i++
            }
        }
        cal()
        return nums.pop().toInt()
    }

    private fun cal() {
        while (ops.isNotEmpty() && ops.peek() != '(') {
            val op = ops.pop()
            val n2 = nums.pop()
            val n1 = nums.pop()
            val sum = if (op == '+') {
                n1 + n2
            } else if (op == '-') {
                n1 - n2
            } else {
                throw IllegalArgumentException("op [$op] is not supported")
            }
            nums.push(sum)
        }
    }

    private fun Char.digitToInt(): Int {
        return this - '0'
    }
}

fun main() {
    Solution224().calculate("(1+(4+5+2)-3)+(6+8)") shouldBe 23
}
