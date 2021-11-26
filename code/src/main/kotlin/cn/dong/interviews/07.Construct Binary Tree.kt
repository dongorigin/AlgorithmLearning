package cn.dong.interviews

/**
 * @author dong on 2018/10/03.
 */
fun main(args: Array<String>) {
    val preOrder = listOf(1, 2, 4, 7, 3, 5, 6, 8)
    val inOrder = listOf(4, 7, 2, 1, 5, 3, 8, 6)
    val tree = createTree(preOrder, inOrder)
    println(tree.preOrderTraversal())
    println(tree.inOrderTraversal())

    val preOrder2 = listOf(1, 2, 3)
    val inOrder2 = listOf(3, 2, 1)
    val tree2 = createTree(preOrder2, inOrder2)
    println(tree2.preOrderTraversal())
    println(tree2.inOrderTraversal())

    val preOrder3 = emptyList<Int>()
    val inOrder3 = emptyList<Int>()
    val tree3 = createTree(preOrder3, inOrder3)
    println(tree3.preOrderTraversal())
    println(tree3.inOrderTraversal())
}

/**
 * 通过前序序列与中序序列重建二叉树
 */
fun <E> createTree(preOrder: List<E>, inOrder: List<E>): BinaryTree<E> {
    val binaryTree = BinaryTree<E>()
    binaryTree.root = createSubTree(preOrder, inOrder)
    return binaryTree
}

private fun <E> createSubTree(preOrder: List<E>, inOrder: List<E>): BinaryTree.Node<E>? {
    require(preOrder.size == inOrder.size) { "pre order and in order are not equal in size" }
    if (preOrder.isEmpty()) { // in-order same empty
        return null // recursion exit
    }
    val rootItem = preOrder[0]
    val root = BinaryTree.Node(rootItem)
    if (preOrder.size == 1) {
        return root // recursion exit
    }
    val inOrderRootIndex = inOrder.indexOf(rootItem)
    val leftSize = inOrderRootIndex
    val rightSize = inOrder.size - leftSize - 1
    if (leftSize > 0) {
        root.left = createSubTree(preOrder.subList(1, 1 + leftSize), inOrder.subList(0, leftSize))
    }
    if (rightSize > 0) {
        root.right = createSubTree(preOrder.subList(1 + leftSize, preOrder.size), inOrder.subList(inOrderRootIndex + 1, inOrder.size))
    }
    return root
}
