package cn.dong.leetcode

/**
 * [206. 反转链表 - 力扣（LeetCode）](https://leetcode-cn.com/problems/reverse-linked-list/)
 *
 * @author dong on 2021/12/13.
 */
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
