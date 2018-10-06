package cn.dong.interviews

/**
 * 用栈实现队列
 *
 * @author dong on 2018/10/03.
 */
fun main(args: Array<String>) {
    val queue = StackQueue<Int>()
    queue.enqueue(1)
    queue.enqueue(2)
    println(queue.dequeue())
    println(queue.dequeue())
}

/**
 * queue with two stacks
 */
class StackQueue<E> {
    private val pushStack = Stack<E>()
    private val popStack = Stack<E>()

    val size: Int
        get() = pushStack.size + popStack.size

    fun isEmpty(): Boolean = size == 0

    fun enqueue(item: E) {
        pushStack.push(item)
    }

    fun dequeue(): E {
        if (popStack.isEmpty()) {
            while (pushStack.isNotEmpty()) {
                popStack.push(pushStack.pop())
            }
        }
        if (popStack.isEmpty()) throw NoSuchElementException()
        return popStack.pop()
    }
}

/**
 * stack with two queues
 */
class QueueStack<E> {
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
