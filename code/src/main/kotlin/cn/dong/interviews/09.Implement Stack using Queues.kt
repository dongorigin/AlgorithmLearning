package cn.dong.interviews

/**
 * stack with two queues
 *
 * @author dong on 2018/10/03.
 */
private class QueueStack<E> {
    private val queue1 = Queue<E>()
    private val queue2 = Queue<E>()

    val size: Int
        get() = queue1.size + queue2.size

    fun isEmpty(): Boolean = size == 0

    fun push(item: E) {
        val pushQueue = when {
            queue1.isEmpty() -> queue2
            queue2.isEmpty() -> queue1
            else -> throw IllegalStateException("two queues are not empty")
        }
        pushQueue.enqueue(item)
    }

    fun pop(): E {
        if (isEmpty()) throw NoSuchElementException("two queues are empty")
        val (emptyQueue, itemQueue) = when {
            queue1.isEmpty() -> Pair(queue1, queue2)
            queue2.isEmpty() -> Pair(queue2, queue1)
            else -> throw IllegalStateException("two queues are not empty")
        }
        while (itemQueue.size > 1) {
            emptyQueue.enqueue(itemQueue.dequeue())
        }
        return itemQueue.dequeue()
    }
}

fun main(args: Array<String>) {
    val stack = QueueStack<Int>()
    for (i in 1..5) {
        stack.push(i)
    }
    while (!stack.isEmpty()) {
        println(stack.pop())
    }
}
