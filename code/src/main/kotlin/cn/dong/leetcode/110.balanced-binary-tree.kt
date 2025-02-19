package cn.dong.leetcode

import io.kotest.matchers.shouldBe

/**
 * [110. 平衡二叉树 - 力扣（LeetCode）](https://leetcode-cn.com/problems/balanced-binary-tree/)
 *
 * @author dong on 2021/12/22.
 */
class Solution110 {
    var count = 0 // for benchmark

    /** 后序遍历，从底至顶处理子树，同时算子树的高度和判断平衡，避免了重复遍历，时间复杂度 O(n) */
    fun isBalanced(root: TreeNode?): Boolean {
        return height(root) >= 0
    }

    /** 返回树的高度，同时判断树是否平衡，不平衡返回 -1。因为 */
    fun height(root: TreeNode?): Int {
        if (root == null) return 0
        count++
        val leftH = height(root.left)
        if (leftH < 0) return -1

        val rightH = height(root.right)
        if (rightH < 0) return -1

        if (Math.abs(leftH - rightH) > 1) return -1
        return 1 + Math.max(leftH, rightH)
    }
}

class Solution110_2 {
    var count = 0 // for benchmark

    /** 对每个子树会重复计算多次 height，时间复杂度 O(n log n) */
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) return true
        return isBalanced(root.left)
                && isBalanced(root.right)
                && Math.abs((height(root.left) - height(root.right))) <= 1
    }

    private fun height(root: TreeNode?): Int {
        if (root == null) return 0
        count++
        return 1 + Math.max(height(root.left), height(root.right))
    }
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2).apply {
        left = TreeNode(4).apply {
            left = TreeNode(8)
        }
        right = TreeNode(5)
    }
    root.right = TreeNode(3).apply {
        left = TreeNode(6).apply {
            right = TreeNode(13)
        }
        right = TreeNode(7).apply {
            left = TreeNode(14).apply {
                left = TreeNode(28)
            }
            right = TreeNode(15)
        }
    }

    val solution110 = Solution110()
    solution110.isBalanced(root) shouldBe true
    println("first ${solution110.count}")
    val solution1102 = Solution110_2()
    solution1102.isBalanced(root) shouldBe true
    println("second ${solution1102.count}")
}
