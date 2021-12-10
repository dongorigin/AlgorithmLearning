package cn.dong.leetcode

import java.util.*

/**
 * https://leetcode-cn.com/problems/remove-k-digits/
 * 贪心
 *
 * @author dong on 2021/12/10.
 */
fun removeKdigits(num: String, k: Int): String {
    val deque: Deque<Int> = LinkedList()
    var count = k
    for (char in num) {
        val digit = char - '0'
        while (count > 0 && deque.isNotEmpty() && digit < deque.peekLast()) {
            count--
            deque.pollLast()
        }
        deque.offerLast(digit)
    }
    while (count > 0) {
        count--
        deque.pollLast()
    }

    val sb = StringBuilder(deque.size)
    var skipZero = true
    while (deque.isNotEmpty()) {
        val d = deque.pollFirst()
        if (d == 0 && skipZero) continue

        sb.append(d)
        skipZero = false
    }

    return if (sb.isNotEmpty()) sb.toString() else "0"
}

fun removeKdigitsByStack(num: String, k: Int): String {
    val stack = Stack<Int>()
    var count = k
    for (char in num) {
        val digit = char - '0'
        while (count > 0 && stack.isNotEmpty() && digit < stack.peek()) {
            count--
            stack.pop()
        }
        stack.push(digit)
    }
    while (count > 0) {
        count--
        stack.pop()
    }

    // reverse + remove start zero
    val sb = StringBuilder(stack.size)
    var zeroTemp = 0
    while (stack.isNotEmpty()) {
        val d = stack.pop()
        if (d == 0) {
            zeroTemp++
        } else {
            while (zeroTemp > 0) {
                zeroTemp--
                sb.insert(0, "0")
            }
            sb.insert(0, d.toString())
        }
    }
    return if (sb.isNotEmpty()) sb.toString() else "0"

    // or
    // stack.joinToString(separator = "") { it.toString() }.trimStart('0').ifEmpty { "0" }
}

fun main() {
    val stack = Stack<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.pop()
    stack.push(4)
    stack.forEach { println(it) }
    println(stack.toList().toString())
}
