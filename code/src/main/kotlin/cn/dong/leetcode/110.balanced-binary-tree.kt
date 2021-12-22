package cn.dong.leetcode

/**
 * [110. 平衡二叉树 - 力扣（LeetCode）](https://leetcode-cn.com/problems/balanced-binary-tree/)
 *
 * @author dong on 2021/12/22.
 */
class Solution110 {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) return true
        return isBalanced(root.left)
                && isBalanced(root.right)
                && abs((height(root.left) - height(root.right))) <= 1
    }

    private fun abs(i: Int): Int = if (i >= 0) i else -i

    private fun max(i: Int, j: Int): Int = if (i > j) i else j

    private fun height(root: TreeNode?): Int {
        if (root == null) return 0
        return 1 + max(height(root.left), height(root.right))
    }
}
