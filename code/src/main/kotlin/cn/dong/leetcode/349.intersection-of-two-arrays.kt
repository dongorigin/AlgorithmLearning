package cn.dong.leetcode

/**
 * [349. 两个数组的交集 - 力扣（LeetCode）](https://leetcode-cn.com/problems/intersection-of-two-arrays/)
 *
 * @author dong on 2021/12/29.
 */
class Solution349 {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        return (nums1 intersect nums2.toSet()).toIntArray()
    }

    fun intersection2(nums1: IntArray, nums2: IntArray): IntArray {
        val set1 = nums1.toSet()
        val set2 = nums2.toSet()

        val list = mutableListOf<Int>()
        for (i in set1) {
            if (set2.contains(i)) {
                list.add(i)
            }
        }
        return list.toIntArray()
    }
}
