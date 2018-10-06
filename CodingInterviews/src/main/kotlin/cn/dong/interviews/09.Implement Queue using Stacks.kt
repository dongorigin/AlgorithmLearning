package cn.dong.interviews

/**
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
private class StackQueue<E> {
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
