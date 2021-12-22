package cn.dong.leetcode

import java.util.*

/**
 * [102. 二叉树的层序遍历 - 力扣（LeetCode）](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
 * @author dong on 2021/12/22.
 */
class Solution102 {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val lists = mutableListOf<List<Int>>()
        if (root == null) return lists
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val list = mutableListOf<Int>()
            for (i in 1..queue.size) {
                val node = queue.poll()!!
                list.add(node.`val`)
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
            lists.add(list)
        }
        return lists
    }
}