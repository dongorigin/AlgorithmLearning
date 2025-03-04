package cn.dong.leetcode

/**
 * [438. 找到字符串中所有字母异位词 - 力扣（LeetCode）](https://leetcode.cn/problems/find-all-anagrams-in-a-string)
 * 固定滑动窗口
 */
class Solution438 {
    fun findAnagrams(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()
        var start = 0
        val pCountArray = IntArray(26).apply {
            for (char in p) {
                addChar(char)
            }
        }
        val sCountArray = IntArray(26)

        for (end in s.indices) {
            // range [start, end]
            // in
            val inChar = s[end]
            sCountArray.addChar(inChar)
            if (end - start + 1 < p.length) {
                continue
            }

            // update
            if (sCountArray.contentEquals(pCountArray)) {
                result.add(start)
            }

            // out
            val outChar = s[start]
            sCountArray.removeChar(outChar)
            start++
        }
        return result
    }

    private fun IntArray.addChar(char: Char) {
        this[char - 'a']++
    }

    private fun IntArray.removeChar(char: Char) {
        this[char - 'a']--
    }
}

fun main() {
    println(Solution438().findAnagrams("cbaebabacd", "abc"))

    val a = intArrayOf(1, 2)
    val b = intArrayOf(1, 2)
    println(a.contentEquals(b))
    println(a == b)
}