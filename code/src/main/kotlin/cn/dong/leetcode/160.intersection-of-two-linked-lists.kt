package cn.dong.leetcode

/**
 * [160. 相交链表 - 力扣（LeetCode）](https://leetcode.cn/problems/intersection-of-two-linked-lists)
 */
class Solution160 {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        val nodeSet = mutableSetOf<ListNode>()

        var cur = headA
        while (cur != null) {
            nodeSet.add(cur)
            cur = cur.next
        }

        cur = headB
        while (cur != null) {
            if (nodeSet.contains(cur)) {
                return cur
            } else {
                cur = cur.next
            }
        }
        return null
    }
}
