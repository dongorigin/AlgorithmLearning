package cn.dong.interviews

/**
 * @author dong on 2018/10/06.
 */
fun <E> BinaryTree<E>.mirror(): BinaryTree<E> {
    mirrorBinaryTree(root)
    return this
}

private fun <E> mirrorBinaryTree(root: BinaryTree.Node<E>?) {
    if (root == null) return // recursion exit

    val left = root.left
    root.left = root.right
    root.right = left

    mirrorBinaryTree(root.left)
    mirrorBinaryTree(root.right)
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

    println(empty.mirror().breadthFirstTraversal())
    println(one.mirror().breadthFirstTraversal())
    println(treeA.mirror().breadthFirstTraversal())
    println(treeB.mirror().breadthFirstTraversal())
}
