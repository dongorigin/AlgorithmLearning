package cn.dong.leetcode

/**
 * [21. 合并两个有序链表 - 力扣（LeetCode）](https://leetcode-cn.com/problems/merge-two-sorted-lists/)
 *
 * @author dong on 2021/12/15.
 */
class Solution21 {

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var p1 = list1
        var p2 = list2
        val preHead = ListNode(-1)
        var tail = preHead
        while (p1 != null && p2 != null) {
            if (p1.`val` < p2.`val`) {
                tail.next = p1
                tail = p1
                p1 = p1.next
            } else {
                tail.next = p2
                tail = p2
                p2 = p2.next
            }
        }
        if (p1 == null) { // list1 is end
            tail.next = p2
        } else if (p2 == null) { // list2 is end
            tail.next = p1
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

    /**
     * 不使用 dummy/哨兵 头节点，手动处理 head 为空的情况
     */
    fun mergeTwoLists_noDummy(list1: ListNode?, list2: ListNode?): ListNode? {
        var head: ListNode? = null
        var tail: ListNode? = null
        var p1 = list1
        var p2 = list2
        while (p1 != null && p2 != null) {
            if (p1.`val` <= p2.`val`) {
                // move p1 to new list
                if (tail == null) {
                    head = p1
                } else {
                    tail.next = p1
                }
                tail = p1
                p1 = p1.next
                tail.next = null
            } else {
                // move p2 to new list
                if (tail == null) {
                    head = p2
                } else {
                    tail.next = p2
                }
                tail = p2
                p2 = p2.next
                tail.next = null
            }
        }
        if (p1 == null) { // list1 is end
            if (tail == null) {
                head = p2
            } else {
                tail.next = p2
            }
        } else if (p2 == null) { // list2 is end
            if (tail == null) {
                head = p1
            } else {
                tail.next = p1
            }
        }
        return head
    }
}
