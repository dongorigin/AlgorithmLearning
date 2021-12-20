package cn.dong.leetcode

import java.util.*

/**
 * [145. 二叉树的后序遍历 - 力扣（LeetCode）](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)
 *
 * @author dong on 2021/12/20.
 */
class Solution145 {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val result = mutableListOf<Int>()
        result.addAll(postorderTraversal(root.left))
        result.addAll(postorderTraversal(root.right))
        result.add(root.`val`)
        return result
    }

    fun postorderTraversalByIteration(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        val stack = Stack<TreeNode>()
        var cur = root
        var prev: TreeNode? = null
        while (cur != null || stack.isNotEmpty()) {
            if (cur != null) {
                stack.push(cur)
                cur = cur.left
            } else {
                cur = stack.peek()
                if (cur.right != null && cur.right != prev) {
                    cur = cur.right
                } else {
                    result.add(cur.`val`)
                    stack.pop()
                    prev = cur
                    cur = null
                }
            }
        }
        return result
    }
}
