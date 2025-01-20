package cn.dong.leetcode

/**
 * [92. 反转链表 II - 力扣（LeetCode）](https://leetcode-cn.com/problems/reverse-linked-list-ii/)
 *
 * @author dong on 2021/12/13.
 */
class Solution92 {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        val prevHead = ListNode(-1)
        prevHead.next = head
        var prevLeft = prevHead

        for (i in 1..left - 1) {
            prevLeft = prevLeft.next!!
        }
        val cur = prevHead.next

        for (i in 1..right - left) {
            val next = cur?.next
            cur?.next = next?.next
            next?.next = prevLeft.next
            prevLeft.next = next
        }
        return prevHead.next
    }
}
