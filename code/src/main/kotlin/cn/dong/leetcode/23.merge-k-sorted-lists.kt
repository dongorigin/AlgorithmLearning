package cn.dong.leetcode

import java.util.PriorityQueue

/**
 * [23. 合并 K 个升序链表 - 力扣（LeetCode）](https://leetcode.cn/problems/merge-k-sorted-lists/)
 */
class Solution_23 {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val prevHead = ListNode(-1)
        var current = prevHead

        val minHeap = PriorityQueue<ListNode> { node1, node2 ->
            node1.`val`.compareTo(node2.`val`)
        }
        minHeap.addAll(lists.filterNotNull())

        while (minHeap.isNotEmpty()) {
            val node = minHeap.poll()
            current.next = node
            current = node
            if (node.next != null) {
                minHeap.add(node.next)
            }
        }

        return prevHead.next
    }
}