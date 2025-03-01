package cn.dong.leetcode


/**
 * [49. 字母异位词分组 - 力扣（LeetCode）](https://leetcode.cn/problems/group-anagrams)
 */
class Solution49 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>() // < sorted str, wordList >
        for (str in strs) {
            val sortedCharArray = str.toCharArray().sortedArray().concatToString()
            val wordList = map.getOrPut(sortedCharArray) { mutableListOf() }
            wordList.add(str)
        }
        return map.map { it.value }
    }


    fun groupAnagrams2(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<Map<Char, Int>, MutableList<String>>() // < <Char,Count>, wordList >
        for (str in strs) {
            val charToCount = str.toMap()
            val wordList = map.getOrPut(charToCount) { mutableListOf() }
            wordList.add(str)
        }
        return map.map { it.value }
    }

    private fun String.toMap(): Map<Char, Int> {
        val charToCount = mutableMapOf<Char, Int>()
        for (char in this) {
            charToCount[char] = charToCount.getOrDefault(char, 0) + 1
        }
        return charToCount
    }
}
