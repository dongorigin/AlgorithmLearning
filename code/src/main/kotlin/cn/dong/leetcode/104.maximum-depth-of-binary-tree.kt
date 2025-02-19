package cn.dong.leetcode

import kotlin.math.max

/**
 * [104. 二叉树的最大深度 - 力扣（LeetCode）](https://leetcode.cn/problems/maximum-depth-of-binary-tree/)
 */
class Solution_104 {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        return 1 + max(maxDepth(root.left), maxDepth(root.right))
    }
}
