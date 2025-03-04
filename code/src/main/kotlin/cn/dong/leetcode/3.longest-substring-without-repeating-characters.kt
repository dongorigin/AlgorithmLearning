package cn.dong.leetcode

import kotlin.math.max

/**
 * [3. 无重复字符的最长子串 - 力扣（LeetCode）](https://leetcode.cn/problems/longest-substring-without-repeating-characters)
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 */
class Solution3 {
    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0
        var maxLen = 0
        val charSet = mutableSetOf<Char>()
        for (end in s.indices) {
            val char = s[end]
            while (charSet.contains(char)) {
                charSet.remove(s[start])
                start++
            }
            val len = charSet.size
            maxLen = max(maxLen, len)
        }
        return maxLen
    }
}