package cn.dong.leetcode

/**
 * [22. 括号生成 - 力扣（LeetCode）](https://leetcode-cn.com/problems/generate-parentheses/)
 *
 * @author dong on 2022/01/05.
 */
class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        dfs("", n, 0, result)
        return result
    }

    private fun dfs(path: String, remainLeft: Int, existLeft: Int, result: MutableList<String>) {
        if (remainLeft == 0 && existLeft == 0) {
            result.add(path)
            return
        }
        if (existLeft > 0) {
            dfs(path + ")", remainLeft, existLeft - 1, result)
        }
        if (remainLeft > 0) {
            dfs(path + "(", remainLeft - 1, existLeft + 1, result)
        }
    }
}
