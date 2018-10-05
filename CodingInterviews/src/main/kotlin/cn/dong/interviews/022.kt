package cn.dong.interviews

import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull

/**
 * find the last [k] item in the linked list
 *
 * @author dong on 2018/10/05.
 */
fun <E> LinkedList<E>.findLast(k: Int): E? {
    require(k > 0)
    var forward = first
    var target = first
    for (i in 0 until k - 1) {
        if (forward?.next != null) {
            forward = forward.next
        } else {
            // k > n
            // 我认为在实际使用中，链表作为一个集合数据结构，理应自己维护 size，要比调用者迂回作战靠谱的多
            return null
        }
    }
    while (forward?.next != null && target?.next != null) {
        forward = forward.next
        target = target.next
    }
    return target?.item
}

fun main(args: Array<String>) {
    assertNull(LinkedList<Int>().findLast(1))

    val linkedList = LinkedList(listOf(1, 2, 3, 4, 5))
    assertFailsWith(IllegalArgumentException::class) { linkedList.findLast(-1) }
    assertFailsWith(IllegalArgumentException::class) { linkedList.findLast(0) }
    assertEquals(5, linkedList.findLast(1))
    assertEquals(4, linkedList.findLast(2))
    assertEquals(1, linkedList.findLast(5))
    assertNull(linkedList.findLast(6))
}
