package cn.dong.leetcode

/**
 * [101. 对称二叉树 - 力扣（LeetCode）](https://leetcode-cn.com/problems/symmetric-tree/)
 *
 * 如何判断二叉树是镜像的？左子树与右子树是镜像的。
 * 如何判断两棵树是镜像的？树A的左子树与树B的右子树是镜像的 && 树A的右子树与树B的左子树是镜像的
 *
 * @author dong on 2021/12/22.
 */
class Solution101 {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        return treeIsSymmetric(root.left, root.right)
    }

    /** 两棵树是对称的 */
    fun treeIsSymmetric(a: TreeNode?, b: TreeNode?): Boolean {
        return if (a != null && b != null) {
            a.`val` == b.`val`
                    && treeIsSymmetric(a.left, b.right)
                    && treeIsSymmetric(a.right, b.left)
        } else {
            a == null && b == null
        }
    }
}