package cn.dong.leetcode

/**
 * [24. 两两交换链表中的节点 - 力扣（LeetCode）](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)
 *
 * @author dong on 2021/12/22.
 */
class Solution24 {
    fun swapPairs(head: ListNode?): ListNode? {
        val dummy = ListNode(-1)
        dummy.next = head
        var prev = dummy
        while (prev.next != null && prev.next!!.next != null) {
            val cur = prev.next!!
            val next = prev.next!!.next
            cur.next = next?.next
            next?.next = cur
            prev.next = next
            prev = cur
        }
        return dummy.next
    }
}
