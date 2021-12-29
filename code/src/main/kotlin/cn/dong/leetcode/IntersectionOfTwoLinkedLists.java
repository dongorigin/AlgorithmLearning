package cn.dong.leetcode;

/**
 * [面试题 02.07. 链表相交 - 力扣（LeetCode）](https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/)
 *
 * @author dong on 2021/12/29.
 */
public class IntersectionOfTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        int sizeB = 0;
        ListNode targetA = headA;
        ListNode targetB = headB;
        while (targetA != null) {
            sizeA++;
            targetA = targetA.next;
        }
        while (targetB != null) {
            sizeB++;
            targetB = targetB.next;
        }

        targetA = headA;
        targetB = headB;
        if (sizeA >= sizeB) {
            int sub = sizeA - sizeB;
            while (sub > 0) {
                sub--;
                targetA = targetA.next;
            }
        } else {
            int sub = sizeB - sizeA;
            while (sub > 0) {
                sub--;
                targetB = targetB.next;
            }
        }
        while (targetA != null) {
            if (targetA == targetB) {
                return targetA;
            } else {
                targetA = targetA.next;
                targetB = targetB.next;
            }
        }
        return null;
    }
}