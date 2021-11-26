package cn.dong.interviews

import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Returns `true` if [tree] is substructure in this, `false` otherwise
 *
 * @author dong on 2018/10/06.
 */
fun <E> BinaryTree<E>.hasSubstructure(tree: BinaryTree<E>): Boolean {
    return hasSubstructure(this.root, tree.root)
}

/**
 * Returns `true` if tree [rootB] is a substructure of tree [rootA]
 */
private fun <E> hasSubstructure(rootA: BinaryTree.Node<E>?, rootB: BinaryTree.Node<E>?): Boolean {
    if (rootA == null || rootB == null) {
        return false // recursion exit
    }
    var result = false
    if (rootA.item == rootB.item) {
        result = isSubstructure(rootA, rootB)
    }
    if (!result) {
        result = hasSubstructure(rootA.left, rootB)
    }
    if (!result) {
        result = hasSubstructure(rootA.right, rootB)
    }
    return result
}

/**
 * tree [rootA] contains tree [rootB] in the same root node
 */
private fun <E> isSubstructure(rootA: BinaryTree.Node<E>?, rootB: BinaryTree.Node<E>?): Boolean {
    if (rootB == null) {
        return true // tree B has no more nodes
    }
    if (rootA == null) {
        return false // tree A has no more nodes, but tree B has
    }
    if (rootA.item == rootB.item) {
        return isSubstructure(rootA.left, rootB.left) && isSubstructure(rootA.right, rootB.right)
    } else {
        return false
    }
}

fun main(args: Array<String>) {
    //   A=B     C    D    E
    //    a      a    a    a
    //   / \      \    \    \
    //  b   c      c    d    d
    // / \ / \           \
    // # d e #            e
    val emptyTree = BinaryTree<String>()
    val treeA = BinaryTree.Creator(arrayOf("a", "b", "#", "d", "#", "#", "c", "e"), { it == "#" }).create()
    val treeB = BinaryTree.Creator(arrayOf("a", "b", "#", "d", "#", "#", "c", "e"), { it == "#" }).create()
    val treeC = BinaryTree.Creator(arrayOf("a", "#", "c"), { it == "#" }).create()
    val treeD = BinaryTree.Creator(arrayOf("a", "#", "d", "#", "e"), { it == "#" }).create()
    val treeE = BinaryTree.Creator(arrayOf("a", "#", "d"), { it == "#" }).create()

    assertFalse(emptyTree.hasSubstructure(emptyTree))
    assertFalse(emptyTree.hasSubstructure(treeA))
    assertFalse(treeA.hasSubstructure(emptyTree))

    assertTrue(treeA.hasSubstructure(treeA)) // self
    assertTrue(treeA.hasSubstructure(treeB)) // equals
    assertTrue(treeA.hasSubstructure(treeC)) // contains
    assertTrue(treeD.hasSubstructure(treeE)) // only right child
}
