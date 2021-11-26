package cn.dong.interviews

/**
 * 反转链表，原地修改
 *
 * @author dong on 2018/10/05.
 */
fun <E> reverseLinkedList(list: LinkedList<E>) {
    var prev: LinkedList.Node<E>? = null
    var target: LinkedList.Node<E>? = list.first
    while (target != null) {
        val next = target.next
        target.next = prev
        list.first = target

        prev = target
        target = next
    }
}

fun main(args: Array<String>) {
    reverseAndPrintLinkedList(LinkedList<Int>())
    reverseAndPrintLinkedList(LinkedList(listOf(1)))
    reverseAndPrintLinkedList(LinkedList(listOf(1, 2, 3, 4, 5)))
}

private fun <E> reverseAndPrintLinkedList(linkedList: LinkedList<E>) {
    reverseLinkedList(linkedList)
    println(linkedList.joinToString())
}
