package cn.dong.leetcode

/**
 * [257. 二叉树的所有路径 - 力扣（LeetCode）](https://leetcode-cn.com/problems/binary-tree-paths/)
 * @author dong on 2022/01/05.
 */
class Solution257 {
    /** 思路最直观，但产生中间对象较多 */
    fun binaryTreePaths(root: TreeNode?): List<String> {
        if (root == null) return emptyList()
        if (root.left == null && root.right == null) return listOf(root.`val`.toString())
        val result = mutableListOf<String>()
        result.addAll(binaryTreePaths(root.left))
        result.addAll(binaryTreePaths(root.right))
        return result.map { "${root.`val`}->$it" }
    }
}
