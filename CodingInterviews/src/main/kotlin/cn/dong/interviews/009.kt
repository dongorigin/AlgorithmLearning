package cn.dong.interviews

/**
 * 用栈实现队列
 *
 * @author dong on 2018/10/03.
 */
fun main(args: Array<String>) {
    val queue = Queue<Int>()
    queue.enqueue(1)
    queue.enqueue(2)
    println(queue.dequeue())
    println(queue.dequeue())
}

class Queue<E> {
    private val pushStack = Stack<E>()
    private val popStack = Stack<E>()

    var size: Int = 0
        private set

    fun isEmpty(): Boolean = size == 0

    fun enqueue(item: E) {
        pushStack.push(item)
        size++
    }

    fun dequeue(): E {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop())
            }
        }
        if (popStack.isEmpty()) throw NoSuchElementException()
        size--
        return popStack.pop()
    }
}
