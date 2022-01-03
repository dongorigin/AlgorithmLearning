package cn.dong.leetcode

/**
 * [1047. 删除字符串中的所有相邻重复项 - 力扣（LeetCode）](https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/)
 *
 * @author dong on 2021/12/29.
 */
class Solution1047 {
    fun removeDuplicates(s: String): String {
        val sb = StringBuilder()
        for (char in s) {
            if (sb.lastOrNull() == char) {
                sb.deleteCharAt(sb.length - 1)
            } else {
                sb.append(char)
            }
        }
        return sb.toString()
    }
}
