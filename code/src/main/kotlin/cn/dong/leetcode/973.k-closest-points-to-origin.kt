package cn.dong.leetcode

import java.util.PriorityQueue
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * [973. 最接近原点的 K 个点 - 力扣（LeetCode）](https://leetcode.cn/problems/k-closest-points-to-origin)
 */
class Solution_973 {

    class Point(val p: IntArray) {
        val distanceToOrigin: Double = sqrt(p[0].pow(2) + p[1].pow(2))
    }

    // top k
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val maxHeap = PriorityQueue<Point> { o1, o2 ->
            o2.distanceToOrigin.compareTo(o1.distanceToOrigin)
        }

        for (point in points) {
            val element = Point(point)
            if (maxHeap.size < k || element.distanceToOrigin < maxHeap.peek().distanceToOrigin) {
                maxHeap.add(element)
            }
            if (maxHeap.size > k) {
                maxHeap.poll()
            }
        }
        return maxHeap.map { it.p }.toTypedArray()
    }
}

fun Int.pow(n: Int): Double {
    return this.toDouble().pow(n)
}
