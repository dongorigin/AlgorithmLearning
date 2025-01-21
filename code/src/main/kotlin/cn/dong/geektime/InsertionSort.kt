package cn.dong.geektime

/**
 * 已排序区间从前往后遍历
 */
fun insertionSort(array: Array<Int>) {
    for (i in 1..array.size-1) { // 每轮选择未排序区间 [i,size-1] 的第一个元素
        val target = array[i]
        for (j in 0..i-1) { // 已排序区间 [0,i-1] 的每个元素依次对比
            if (target < array[j]) {
                // 将 array[i] 插入到 j 的位置，array[j] 和后面整体后移一位。
                for (x in j..i - 1) {
                    array[x+1] = array[x]
                }
                array[j] = target
                break
            }
        }
    }
}

/**
 * 已排序区间从后往前遍历
 */
fun insertionSort2(array: Array<Int>) {
    for (i in 1..array.size-1) { // 每轮选择未排序区间 [i,size-1] 的第一个元素
        val target = array[i]
        for (j in i-1 downTo 0) { // 已排序区间 [0,i-1] 的每个元素依次对比
            if (target < array[j]) {
                array[j + 1] = array[j]
                array[j] = target
            } else {
                break
            }
        }
    }
}


fun main() {
    val array = arrayOf(1, 3, 2, 5, 4, 6)
    insertionSort2(array)
    println(array.joinToString())
}