package cn.dong.interviews

/**
 *
 * @author dong on 2018/10/02.
 */
class LinkedList<E>() : Iterable<E> {
    private var first: Node<E>? = null
    var size = 0
        private set

    constructor(iterable: Iterable<E>) : this() {
        for (item in iterable.iterator()) {
            add(item)
        }
    }

    fun isEmpty(): Boolean = size == 0

    fun getHead() = first  // 因算法需要而暴露，通常情况下应该隐藏内部实现

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
