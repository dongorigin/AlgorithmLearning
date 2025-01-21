package cn.dong.geektime

/**
 * 从小到大排序
 */
fun bubbleSort(array: Array<Int>) {
    for (i in 1..array.size) { // 每轮冒泡只能让一个元素达到预期位置，所以需要 size 轮
        for (j in 0..array.size - i - 1) { // 第一轮,上限 size-2. 第二轮，上限 size-3
            if (array[j] > array[j + 1]) {
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
    }
}

fun main() {
    val array = arrayOf(1, 3, 2, 5, 4, 6)
    bubbleSort(array)
    println(array.joinToString())
}