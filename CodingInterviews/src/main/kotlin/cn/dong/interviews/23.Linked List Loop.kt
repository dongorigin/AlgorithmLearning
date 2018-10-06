package cn.dong.interviews

import kotlin.test.assertEquals
import kotlin.test.assertNull

/**
 * find entry node of loop in the linked list, or `null` of the linked list does not contain loop
 *
 * @author dong on 2018/10/05.
 */
fun <E> LinkedList<E>.findEntryNodeOfLoop(): LinkedList.Node<E>? {
    val loopSize = getLoopSize()
    if (loopSize <= 0) return null
    var ahead = first
    var behind = first
    for (i in 0 until loopSize) {
        ahead = ahead?.next ?: throw IllegalStateException("node.next is `null` in the case contain loop")
    }
    while (ahead != behind) {
        ahead = ahead?.next
        behind = behind?.next
    }
    return ahead
}

/**
 * return loop size, or 0 if the linked list does not contain loop
 */
private fun <E> LinkedList<E>.getLoopSize(): Int {
    val nodeInLoop: LinkedList.Node<E> = findNodeInLoop() ?: return 0
    var target = nodeInLoop
    var size = 0
    while (true) {
        target = target.next ?: throw IllegalStateException("node.next is `null` in loop")
        size++
        if (target == nodeInLoop) {
            return size
        }
    }
}

/**
 * return node in the loop, or `null` if the linked list does not contain loop
 */
private fun <E> LinkedList<E>.findNodeInLoop(): LinkedList.Node<E>? {
    var slow = first
    var fast = first?.next
    while (fast != null && slow != null) {
        if (fast == slow) {
            return fast
        } else {
            fast = fast.next?.next
            slow = slow.next
        }
    }
    return null
}

fun main(args: Array<String>) {
    val empty = LinkedList<Int>()
    assertEquals(0, empty.getLoopSize())
    assertNull(empty.findEntryNodeOfLoop())

    val oneNoLoop = LinkedList(listOf(1))
    assertEquals(0, empty.getLoopSize())
    assertNull(oneNoLoop.findEntryNodeOfLoop())

    val oneHasLoop = LinkedList(listOf(1)).apply {
        first?.next = first
    }
    assertEquals(1, oneHasLoop.getLoopSize())
    assertEquals(oneHasLoop.first, oneHasLoop.findEntryNodeOfLoop())

    val threeNoLoop = LinkedList(listOf(1, 2, 3))
    assertEquals(0, empty.getLoopSize())
    assertNull(threeNoLoop.findEntryNodeOfLoop())

    val hasLoop = LinkedList(listOf(1, 2, 3, 4, 5, 6)).apply {
        var last = first
        while (last?.next != null) {
            last = last.next
        }
        last!!.next = first!!.next
    }
    assertEquals(5, hasLoop.getLoopSize())
    assertEquals(hasLoop.first?.next, hasLoop.findEntryNodeOfLoop())
}
