package cn.dong.leetcode

/**
 * [226. 翻转二叉树 - 力扣（LeetCode）](https://leetcode-cn.com/problems/invert-binary-tree/)
 * @author dong on 2021/12/22.
 */
class Solution226 {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val left = root.left
        root.left = invertTree(root.right)
        root.right = invertTree(left)
        return root
    }
}
