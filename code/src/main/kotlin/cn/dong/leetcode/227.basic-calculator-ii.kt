package cn.dong.leetcode

import io.kotest.matchers.shouldBe
import java.util.*

/**
 * [227. 基本计算器 II - 力扣（LeetCode）](https://leetcode-cn.com/problems/basic-calculator-ii/)
 *
 * @author dong on 2021/12/25.
 */
class Solution227 {
    private val opToPriority = mapOf(
        '+' to 1,
        '-' to 1,
        '*' to 2,
        '/' to 2
    )

    private val nums = Stack<Long>()
    private val ops = Stack<Char>()

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
                if (char == '(') {
                    ops.push(char)
                    // 1+(-2)
                    if (i + 1 < input.length && input[i + 1] == '+' || input[i + 1] == '-') {
                        nums.push(0)
                    }
                } else if (char == ')') {
                    while (ops.isNotEmpty()) {
                        val op = ops.peek()
                        if (op == '(') {
                            ops.pop()
                            break
                        } else {
                            cal()
                        }
                    }
                } else if (char.isOp()) {
                    while (ops.isNotEmpty() && ops.peek() != '(' && ops.peek().priority >= char.priority) {
                        cal()
                    }
                    ops.push(char)
                } else throw IllegalArgumentException("char[$char] is not supported")
                i++
            }
        }
        while (ops.isNotEmpty()) {
            cal()
        }
        return nums.pop().toInt()
    }

    private fun cal() {
        val op = ops.pop()
        val n2 = nums.pop()
        val n1 = nums.pop()
        val sum = when (op) {
            '+' -> n1 + n2
            '-' -> n1 - n2
            '*' -> n1 * n2
            '/' -> n1 / n2
            else -> throw IllegalArgumentException("op [$op] is not supported")
        }
        nums.push(sum)
    }

    private fun Char.digitToInt(): Int {
        return this - '0'
    }

    private fun Char.isOp(): Boolean = opToPriority.contains(this)
    private val Char.priority: Int
        get() = opToPriority[this] ?: throw IllegalArgumentException("[$this] is not op")
}

fun main() {
    Solution227().calculate("3+2*2") shouldBe 7
}
