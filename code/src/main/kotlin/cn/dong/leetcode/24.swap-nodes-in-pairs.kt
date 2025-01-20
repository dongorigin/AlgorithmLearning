package cn.dong.leetcode

/**
 * [24. 两两交换链表中的节点 - 力扣（LeetCode）](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)
 *
 * @author dong on 2021/12/22.
 */
class Solution24 {
    fun swapPairs(head: ListNode?): ListNode? {
        val prevHead = ListNode(-1)
        prevHead.next = head
        var prev = prevHead
        while (prev.next?.next != null) {
            val p1 = prev.next!!
            val p2 = prev.next!!.next
            p1.next = p2?.next
            p2?.next = p1
            prev.next = p2
            prev = p1
        }
        return prevHead.next
    }
}
