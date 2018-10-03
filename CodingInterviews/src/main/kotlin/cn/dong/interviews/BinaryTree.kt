package cn.dong.interviews

/**
 * @author dong on 2018/10/02.
 */
class BinaryTree<E> {
    var root: Node<E>? = null // 因算法需要而暴露，通常情况下应该隐藏内部实现

    fun isEmpty(): Boolean = root == null

    class Node<E>(val item: E) {
        var left: Node<E>? = null
        var right: Node<E>? = null
    }

    fun preOrderTraversal(): List<E> {
        val list = mutableListOf<E>()
        preOrderTraversal(root, list)
        return list
    }

    private fun preOrderTraversal(node: Node<E>?, list: MutableList<E>) {
        if (node == null) return // recursion exit
        list.add(node.item)
        preOrderTraversal(node.left, list)
        preOrderTraversal(node.right, list)
    }

    fun inOrderTraversal(): List<E> {
        val list = mutableListOf<E>()
        inOrderTraversal(root, list)
        return list
    }

    private fun inOrderTraversal(node: Node<E>?, list: MutableList<E>) {
        if (node == null) return // recursion exit
        inOrderTraversal(node.left, list)
        list.add(node.item)
        inOrderTraversal(node.right, list)
    }

    fun postOrderTraversal(): List<E> {
        val list = mutableListOf<E>()
        postOrderTraversal(root, list)
        return list
    }

    private fun postOrderTraversal(node: Node<E>?, list: MutableList<E>) {
        if (node == null) return // recursion exit
        postOrderTraversal(node.left, list)
        postOrderTraversal(node.right, list)
        list.add(node.item)
    }

    /**
     * 通过扩展前序序列构造二叉树。[predicate] `true` 表示空树叶
     * 比如 [a,b,#,#,c], # 表示空树叶
     */
    class Creator<E>(
            private val array: Array<E>,
            private val predicate: (E) -> Boolean) {
        private var index: Int = 0

        fun create(): BinaryTree<E> {
            val tree = BinaryTree<E>()
            if (array.isEmpty()) return tree
            index = 0
            tree.root = createTree()
            return tree
        }

        private fun createTree(): Node<E>? {
            if (index >= array.size) {
                return null
            }
            if (predicate(array[index])) {
                index++
                return null
            }
            val node = Node(array[index++])
            node.left = createTree()
            node.right = createTree()
            return node
        }
    }
}
