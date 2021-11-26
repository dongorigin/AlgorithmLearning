package cn.dong.interviews

import kotlin.math.max
import kotlin.test.assertEquals

/**
 * @author dong on 2018/10/06.
 */
fun <E> BinaryTree<E>.depth(): Int {
    return treeDepth(root)
}

private fun <E> treeDepth(root: BinaryTree.Node<E>?): Int {
    if (root == null) return 0 // recursion exit
    return 1 + max(treeDepth(root.left), treeDepth(root.right))
}

fun main(args: Array<String>) {
    //    A     B
    //    a     a
    //   / \     \
    //  b   c     d
    // / \ / \     \
    // # d e f      e
    val empty = BinaryTree<String>()
    val one = BinaryTree.Creator(arrayOf("a"), { it == "#" }).create()
    val treeA = BinaryTree.Creator(arrayOf("a", "b", "#", "d", "#", "#", "c", "e", "#", "#", "f"), { it == "#" }).create()
    val treeB = BinaryTree.Creator(arrayOf("a", "#", "d", "#", "e"), { it == "#" }).create()

    assertEquals(0, empty.depth())
    assertEquals(1, one.depth())
    assertEquals(3, treeA.depth())
    assertEquals(3, treeB.depth())
}
