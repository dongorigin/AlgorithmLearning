package cn.dong.leetcode

/**
 * [206. 反转链表 - 力扣（LeetCode）](https://leetcode-cn.com/problems/reverse-linked-list/)
 *
 * @author dong on 2021/12/13.
 */
class Solution206 {
    /* 头插法 */
    fun reverseList(head: ListNode?): ListNode? {
        var cur = head
        var newHead : ListNode? = null
        while (cur != null) {
            val next = cur.next
            cur.next = newHead
            newHead = cur
            cur = next
        }
        return newHead
    }

    fun reverseList2(head: ListNode?): ListNode? {
        var prev : ListNode? = null
        var cur = head
        while (cur != null) {
            val next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        }
        return prev
    }

    /* 尾插法 */
    fun reverseListByRecursion(head: ListNode?): ListNode? {
        val next = head?.next
        if (next == null) return head

        val newHead = reverseList(next)
        // 子链表reverse前，next是子链表头节点，子链表reverse后，next就是子链表的尾节点了
        head.next = null
        next.next = head
        return newHead
    }
}
