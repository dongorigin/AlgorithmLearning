package cn.dong.leetcode

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author dong on 2021/12/13.
 */
private class ListNode(val value: Int) {
    var next: ListNode? = null

    override fun toString(): String = value.toString()
}

private fun reverseList(head: ListNode?): ListNode? {
    var target = head
    var h: ListNode? = null
    while (target != null) {
        val next = target.next
        target.next = h
        h = target
        target = next
    }
    return h
}

private fun reverseListByRecursion(head: ListNode?): ListNode? {
    val next = head?.next
    return if (next != null) {
        val h = reverseListByRecursion(next)
        // 子链表reverse前，next是子链表头节点，子链表reverse后，next就是子链表的尾节点了
        next.next = head
        head.next = null
        h
    } else {
        head
    }
}

/** https://leetcode-cn.com/problems/reverse-linked-list-ii/ */
private fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
    val dummy = ListNode(-1)
    dummy.next = head

    var leftPrev = dummy
    var current = dummy.next
    var i = 0
    while (current != null) {
        i++
        if (i < left) {
            leftPrev = current
            current = current.next
        } else if (i < right) {
            val removed = current.next
            current.next = removed?.next

            removed?.next = leftPrev.next
            leftPrev.next = removed
        } else {
            break
        }
    }
    return dummy.next
}

private fun reverseBetween2(head: ListNode?, left: Int, right: Int): ListNode? {
    val dummy = ListNode(-1)
    dummy.next = head

    var leftPrev: ListNode? = dummy
    var current: ListNode? = dummy.next

    for (i in 1 until left) {
        leftPrev = current
        current = current?.next
    }

    for (i in 1..right - left) {
        val removed = current?.next
        current?.next = current?.next?.next

        removed?.next = leftPrev?.next
        leftPrev?.next = removed
    }
    return dummy.next
}
