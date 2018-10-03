package cn.dong.interviews

/**
 * queue with linked list
 *
 * @author dong on 2018/10/03.
 */
class Queue<E> {
    private var first: Node<E>? = null
    private var last: Node<E>? = null

    var size = 0
        private set

    fun isEmpty(): Boolean = size == 0

    fun isNotEmpty(): Boolean = size > 0

    fun enqueue(item: E) {
        val newNode = Node(item)
        if (isEmpty()) {
            first = newNode
            last = newNode
        } else {
            last!!.next = newNode
            last = newNode
        }
        size++
    }

    fun dequeue(): E {
        first?.let {
            first = it.next
            if (first == null) {
                last = null
            }
            it.next = null
            size--
            return it.item
        } ?: throw NoSuchElementException("queue is empty")
    }

    private class Node<E>(
            val item: E,
            var next: Node<E>? = null)
}
