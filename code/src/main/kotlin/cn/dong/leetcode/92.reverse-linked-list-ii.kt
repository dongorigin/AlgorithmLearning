package cn.dong.leetcode

/**
 * [92. 反转链表 II - 力扣（LeetCode）](https://leetcode-cn.com/problems/reverse-linked-list-ii/)
 *
 * @author dong on 2021/12/13.
 */
class Solution92 {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        val dummy = ListNode(-1)
        dummy.next = head

        var leftPrev = dummy
        var cur = dummy.next

        for (i in 1..left - 1) {
            leftPrev = leftPrev.next!!
            cur = cur?.next
        }

        for (i in 1..right - left) {
            val removed = cur!!.next!!
            cur.next = removed.next
            removed.next = leftPrev.next
            leftPrev.next = removed
        }
        return dummy.next
    }
}
