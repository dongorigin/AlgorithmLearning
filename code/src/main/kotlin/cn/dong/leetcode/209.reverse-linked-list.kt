package cn.dong.leetcode

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author dong on 2021/12/13.
 */
private class ListNode(val value: Int) {
    var next: ListNode? = null
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
