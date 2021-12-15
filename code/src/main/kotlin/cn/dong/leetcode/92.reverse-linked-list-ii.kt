package cn.dong.leetcode
/**
 * [92. 反转链表 II - 力扣（LeetCode）](https://leetcode-cn.com/problems/reverse-linked-list-ii/)
 *
 * @author dong on 2021/12/13.
 */
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
