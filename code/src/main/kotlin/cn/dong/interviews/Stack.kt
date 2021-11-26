package cn.dong.interviews

/**
 * @author dong on 2018/10/03.
 */
class Stack<E> {
    private var head: Node<E>? = null
    var size = 0
        private set

    fun push(item: E) {
        val oldHead = head
        head = Node(item, oldHead)
        size++
    }

    fun pop(): E {
        head?.let {
            head = it.next
            it.next = null
            size--
            return it.item
        } ?: throw NoSuchElementException("can't pop, stack is empty")
    }

    fun peek(): E {
        return head?.item ?: throw NoSuchElementException("stack is empty")
    }

    fun isEmpty(): Boolean = size == 0

    fun isNotEmpty(): Boolean = size > 0

    private class Node<E>(
            val item: E,
            var next: Node<E>? = null)
}
