package cn.dong.leetcode

import java.util.*

/**
 * [94. 二叉树的中序遍历 - 力扣（LeetCode）](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)
 *
 * @author dong on 2021/12/20.
 */
class Solution94 {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val result = mutableListOf<Int>()
        result.addAll(inorderTraversal(root.left))
        result.add(root.`val`)
        result.addAll(inorderTraversal(root.right))
        return result
    }

    fun inorderTraversalByIteration(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        val stack = Stack<TreeNode>()
        var cur = root
        while (cur != null || stack.isNotEmpty()) {
            if (cur != null) {
                stack.push(cur)
                cur = cur.left
            } else {
                cur = stack.pop()
                result.add(cur.`val`)
                cur = cur.right
            }
        }
        return result
    }
}

fun main() {
    val root = TreeNode(0)
    root.left = TreeNode(1)
    root.right = TreeNode(2)

    println(Solution94().inorderTraversalByIteration(root))
}
