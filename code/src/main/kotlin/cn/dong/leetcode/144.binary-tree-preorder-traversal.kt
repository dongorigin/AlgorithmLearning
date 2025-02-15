package cn.dong.leetcode

import java.util.*

/**
 * [144. 二叉树的前序遍历 - 力扣（LeetCode）](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)
 *
 * @author dong on 2021/12/20.
 */
class Solution144 {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val result = mutableListOf<Int>()
        result.add(root.`val`)
        result.addAll(preorderTraversal(root.left))  // 执行函数preorderTraversal，此时当前函数未执行代码就相当于被压栈等待了
        result.addAll(preorderTraversal(root.right))
        return result
    }

    fun preorderTraversalByIteration(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        val stack = Stack<TreeNode?>()
        stack.push(root)
        while (stack.size > 0) {
            val node = stack.pop() ?: continue
            result.add(node.`val`)
            stack.add(node.right)
            stack.add(node.left)
        }
        return result
    }

    fun preorderTraversalByIteration2(root: TreeNode?): List<Int> {
        return preorderTraversalByIterationCommon(root)
    }
}