package cn.dong.geek

/**
 * @author dong on 2021/12/03.
 */
interface Heap {

    fun push(item: Int)

    fun pop(): Int

    val top: Int

    val size: Int
}
