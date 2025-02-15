package cn.dong.leetcode

import java.util.*

class StackNode(
    val node: TreeNode?,

    /**
     * true to get node's value,
     * false to visit the left/right child of the node
     */
    var getValue: Boolean
)

fun preorderTraversalByIterationCommon(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()
    val result = mutableListOf<Int>()
    val stack = Stack<StackNode>()
    stack.push(StackNode(root, getValue = false))
    while (stack.isNotEmpty()) {
        val stackNode = stack.pop()
        val node = stackNode.node ?: continue
        if (stackNode.getValue) {
            result.add(node.`val`)
        } else {
            stack.push(StackNode(node.right, getValue = false))
            stack.push(StackNode(node.left, getValue = false))
            stack.push(StackNode(node, getValue = true))
        }
    }
    return result
}

fun inorderTraversalByIterationCommon(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()
    val result = mutableListOf<Int>()
    val stack = Stack<StackNode>()
    stack.push(StackNode(root, getValue = false))
    while (stack.isNotEmpty()) {
        val stackNode = stack.pop()
        val node = stackNode.node ?: continue
        if (stackNode.getValue) {
            result.add(node.`val`)
        } else {
            stack.push(StackNode(node.right, getValue = false))
            stack.push(StackNode(node, getValue = true))
            stack.push(StackNode(node.left, getValue = false))
        }
    }
    return result
}

fun postorderTraversalByIterationCommon(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()
    val result = mutableListOf<Int>()
    val stack = Stack<StackNode>()
    stack.push(StackNode(root, getValue = false))
    while (stack.isNotEmpty()) {
        val stackNode = stack.pop()
        val node = stackNode.node ?: continue
        if (stackNode.getValue) {
            result.add(node.`val`)
        } else {
            stack.push(StackNode(node, getValue = true))
            stack.push(StackNode(node.right, getValue = false))
            stack.push(StackNode(node.left, getValue = false))
        }
    }
    return result
}
