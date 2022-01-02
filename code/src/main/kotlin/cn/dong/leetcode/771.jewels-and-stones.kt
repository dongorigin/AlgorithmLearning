package cn.dong.leetcode

/**
 * [771. 宝石与石头](https://leetcode-cn.com/problems/jewels-and-stones/)
 *
 * @author dong on 2018/08/23.
 */
class JewelsAndStones {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        val array = Array(256) { 0 }
        var count = 0
        stones.forEach { array[it.toInt()]++ }
        jewels.forEach { count += array[it.toInt()] }
        return count
    }
}

fun main(args: Array<String>) {
    val solution = JewelsAndStones()
    assert(solution.numJewelsInStones("aA", "aAAbbbb") == 3)
    assert(solution.numJewelsInStones("z", "ZZ") == 0)
}
