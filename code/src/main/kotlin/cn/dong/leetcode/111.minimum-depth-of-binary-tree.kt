package cn.dong.leetcode

import kotlin.math.min

/**
 * [111. 二叉树的最小深度 - 力扣（LeetCode）](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)
 *
 * @author dong on 2022/01/04.
 */
class Solution111 {
    fun minDepth(root: TreeNode?): Int {
        return when {
            root == null -> 0
            root.left == null && root.right == null -> 1
            root.left == null && root.right != null -> 1 + minDepth(root.right)
            root.left != null && root.right == null -> 1 + minDepth(root.left)
            else -> 1 + min(minDepth(root.left), minDepth(root.right))
        }
    }
}
