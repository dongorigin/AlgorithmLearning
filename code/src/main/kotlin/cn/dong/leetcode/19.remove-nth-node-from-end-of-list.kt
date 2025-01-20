package cn.dong.leetcode

/**
 * [19. 删除链表的倒数第 N 个结点 - 力扣（LeetCode）](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)
 * @author dong on 2021/12/29.
 */
class Solution19 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val prevHead = ListNode(-1)
        prevHead.next = head
        var fast = prevHead
        var prev = prevHead
        for (i in 1..n) {
            fast = fast.next!!
        }
        while (fast.next != null) {
            fast = fast.next!!
            prev = prev.next!!
        }
        // `fast` points to the last item of the list
        prev.next = prev.next?.next
        return prevHead.next
    }
}
