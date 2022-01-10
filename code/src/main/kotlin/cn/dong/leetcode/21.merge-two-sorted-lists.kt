package cn.dong.leetcode

/**
 * [21. 合并两个有序链表 - 力扣（LeetCode）](https://leetcode-cn.com/problems/merge-two-sorted-lists/)
 *
 * @author dong on 2021/12/15.
 */
class Solution21 {

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var l1 = list1
        var l2 = list2
        val preHead = ListNode(-1)
        var prev = preHead
        while (l1 != null && l2 != null) {
            if (l1.`val` < l2.`val`) {
                prev.next = l1
                prev = l1
                l1 = l1.next
            } else {
                prev.next = l2
                prev = l2
                l2 = l2.next
            }
        }
        if (l1 == null) {
            prev.next = l2
        } else {
            prev.next = l1
        }
        return preHead.next
    }

    fun mergeTwoListsByRecursion(list1: ListNode?, list2: ListNode?): ListNode? {
        return if (list1 == null) {
            list2
        } else if (list2 == null) {
            list1
        } else {
            if (list1.`val` < list2.`val`) {
                list1.next = mergeTwoListsByRecursion(list1.next, list2)
                list1
            } else {
                list2.next = mergeTwoListsByRecursion(list1, list2.next)
                list2
            }
        }
    }
}
