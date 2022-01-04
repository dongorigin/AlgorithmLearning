package cn.dong.leetcode

import java.util.*

/**
 * [199. 二叉树的右视图 - 力扣（LeetCode）](https://leetcode-cn.com/problems/binary-tree-right-side-view/)
 *
 * @author dong on 2022/01/04.
 */
class Solution199 {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        if (root == null) return result

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 1..size) {
                val node = queue.poll()
                queue.addIfNull(node.left)
                queue.addIfNull(node.right)
                if (i == size) {
                    result.add(node.`val`)
                }
            }
        }
        return result
    }

    fun <E> Queue<E>.addIfNull(e: E?) {
        if (e != null) {
            add(e)
        }
    }
}
