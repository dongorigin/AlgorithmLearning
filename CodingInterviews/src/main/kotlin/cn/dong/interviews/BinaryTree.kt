package cn.dong.interviews

/**
 * @author dong on 2018/10/02.
 */
class BinaryTree<E> {
    private var root: Node<E>? = null

    fun isEmpty(): Boolean = root == null

    class Node<E>(val item: E) {
        var left: Node<E>? = null
        var right: Node<E>? = null
    }

    fun getRoot(): Node<E>? = root

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
