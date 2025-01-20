package cn.dong.leetcode

/**
 * [203. 移除链表元素 - 力扣（LeetCode）](https://leetcode-cn.com/problems/remove-linked-list-elements/)
 *
 * @author dong on 2021/12/22.
 */
class Solution203 {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val prevHead = ListNode(0)
        prevHead.next = head
        var prev : ListNode? = prevHead
        while (prev?.next != null) {
            if (prev.next?.`val` == `val`) {
                prev.next = prev.next?.next
            } else {
                prev = prev.next
            }
        }
        return prevHead.next
    }
}
