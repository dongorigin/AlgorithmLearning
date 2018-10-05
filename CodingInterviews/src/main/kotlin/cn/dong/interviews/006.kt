package cn.dong.interviews

/**
 * 从尾到头打印链表
 *
 * @author dong on 2018/10/02.
 */
fun main(args: Array<String>) {
    val linkedList = LinkedList(listOf(1, 2, 3, 4, 5))
    reversePrintLinkedList(linkedList)
}

/**
 * 递归实现，不适用大量数据，会栈溢出
 */
fun <E> reversePrintLinkedList(list: LinkedList<E>) {
    printNextNode(list.getHead())
}

fun <E> printNextNode(node: LinkedList.Node<E>?) {
    if (node == null) return // recursion exit
    printNextNode(node.next)
    println(node.item)
}
