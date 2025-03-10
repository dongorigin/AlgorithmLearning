import kotlin.math.max

/**
 * [56. 合并区间 - 力扣（LeetCode）](https://leetcode.cn/problems/merge-intervals)
 */
class Solution56 {
    // 左端点排序后，能合并的一定是连续子数组
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val answer = mutableListOf<IntArray>()

        for (interval in intervals) {
            val lastInterval = answer.lastOrNull()
            if (lastInterval != null && lastInterval[1] >= interval[0]) {
                lastInterval[1] = max(lastInterval[1], interval[1])
            } else {
                answer.add(interval)
            }
        }

        return answer.toTypedArray()
    }
}

fun main() {
    var intArrays = arrayOf(intArrayOf(2, 6), intArrayOf(1, 3), intArrayOf(8, 10), intArrayOf(15, 18))
    println(intArrays.joinToString { it.contentToString() })
    intArrays.sortBy { it[0] }
    println(intArrays.joinToString { it.contentToString() })

}