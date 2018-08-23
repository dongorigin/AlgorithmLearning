package cn.dong.leetcode

/**
 * @author dong on 2018/08/23.
 */
class JewelsAndStones {
    fun numJewelsInStones(J: String, S: String): Int {
        val array = Array<Int>(256, {0})
        var count = 0
        S.forEach { array[it.toInt()]++ }
        J.forEach { count += array[it.toInt()] }
        return count
    }
}

fun main(args: Array<String>) {
    val solution = JewelsAndStones()
    assert(solution.numJewelsInStones("aA", "aAAbbbb") == 3)
    assert(solution.numJewelsInStones("z", "ZZ") == 0)
}