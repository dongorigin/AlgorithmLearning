package cn.dong.interviews

import kotlin.test.assertEquals
import kotlin.test.assertNull

/**
 * find the middle item in the linked list
 *
 * @author dong on 2018/10/05.
 */
fun <E> LinkedList<E>.findMiddle(): E? {
    var forward = first
    var middle = first
    while (forward?.next?.next != null) {
        forward = forward.next?.next
        middle = middle?.next
    }
    return middle?.item
}

fun main(args: Array<String>) {
    assertNull(LinkedList<Int>().findMiddle())
    assertEquals(1, LinkedList(listOf(1)).findMiddle())
    assertEquals(1, LinkedList(listOf(1, 2)).findMiddle())
    assertEquals(2, LinkedList(listOf(1, 2, 3)).findMiddle())
    assertEquals(2, LinkedList(listOf(1, 2, 3, 4)).findMiddle())
    assertEquals(3, LinkedList(listOf(1, 2, 3, 4, 5)).findMiddle())
}
