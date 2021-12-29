package cn.dong.leetcode

/**
 * [19. 删除链表的倒数第 N 个结点 - 力扣（LeetCode）](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)
 * @author dong on 2021/12/29.
 */
class Solution19 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(-1)
        dummy.next = head
        var fast = dummy
        var slow = dummy
        for (i in 1..n) {
            fast = fast.next!!
        }
        while (fast.next != null) {
            fast = fast.next!!
            slow = slow.next!!
        }
        // fast == last
        slow.next = slow.next!!.next
        return dummy.next
    }
}
