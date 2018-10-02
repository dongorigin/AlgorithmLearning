package cn.dong.interviews

/**
 *
 * @author dong on 2018/10/02.
 */
class LinkedList<E> : Iterable<E> {
    private var first: Node<E>? = null
    private var size = 0

    fun size(): Int = size

    fun isEmpty(): Boolean = size == 0

    fun add(element: E) {
        val newNode = Node(element)
        if (first == null) {
            first = newNode
        } else {
            var last = first
            while (last?.next != null) {
                last = last.next
            }
            last!!.next = newNode
        }
        size++
    }

    /**
     * @return `true` if the element has bean successfully removed; `false` if it was not present in the collection.
     */
    fun remove(element: E): Boolean {
        var prev: Node<E>? = null
        var target: Node<E>? = first
        while (target != null) {
            if (target.item == element) {
                // remove target
                if (prev == null) {
                    first = target.next
                } else {
                    prev.next = target.next
                }
                target.next = null
                size--
                return true
            } else {
                prev = target
                target = target.next
            }
        }
        return false
    }

    class Node<E>(
            val item: E,
            var next: Node<E>? = null)

    override fun iterator(): Iterator<E> {
        return NodeIterator(first)
    }

    class NodeIterator<E>(var target: Node<E>?) : Iterator<E> {
        override fun hasNext(): Boolean {
            return target != null
        }

        override fun next(): E {
            val next = target ?: throw NoSuchElementException()
            target = target?.next
            return next.item
        }
    }
}
