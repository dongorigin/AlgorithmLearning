package cn.dong.leetcode

/**
 * [876. 链表的中间结点 - 力扣（LeetCode）](https://leetcode.cn/problems/middle-of-the-linked-list/)
 */
class Solution876 {
    fun middleNode(head: ListNode?): ListNode? {
        var fast = head
        var slow = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }
        // fast points to the last item of the list
        return slow
    }
}