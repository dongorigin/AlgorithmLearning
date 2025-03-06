package cn.dong.leetcode

import kotlin.math.max

/**
 * [543. 二叉树的直径 - 力扣（LeetCode）](https://leetcode.cn/problems/diameter-of-binary-tree/)
 */
class Solution543 {
    var max = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        depth(root)
        return max
    }

    fun depth(root: TreeNode?): Int {
        if (root == null) return 0
        val leftD = depth(root.left)
        val rightD = depth(root.right)

        // update diameter
        val diameter = leftD + rightD
        if (diameter > max) {
            max = diameter
        }

        return max(leftD, rightD) + 1
    }
}
