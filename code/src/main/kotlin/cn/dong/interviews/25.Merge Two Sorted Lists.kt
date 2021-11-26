package cn.dong.interviews

/**
 * sort merge ordered lists [list1] and [list2]
 *
 * @author dong on 2018/10/06.
 */
fun <E : Comparable<E>> merge(list1: LinkedList<E>, list2: LinkedList<E>): LinkedList<E> {
    val newList = LinkedList<E>()
    newList.first = merge(list1.first, list2.first)
    return newList
}

/**
 * merge linked list by list1 [head1] and list2 [head2], return merged list head node
 */
private fun <E : Comparable<E>> merge(head1: LinkedList.Node<E>?, head2: LinkedList.Node<E>?): LinkedList.Node<E>? {
    if (head1 == null) {
        return head2 // recursion exit
    }
    if (head2 == null) {
        return head1 // recursion exit
    }
    val newHead: LinkedList.Node<E>
    if (head1.item < head2.item) {
        newHead = head1
        newHead.next = merge(head1.next, head2)
    } else {
        newHead = head2
        newHead.next = merge(head1, head2.next)
    }
    return newHead
}

fun main(args: Array<String>) {
    val empty1 = LinkedList<Int>()
    val empty2 = LinkedList<Int>()

    mergeAndPrint(empty1, empty2)
    mergeAndPrint(empty1, LinkedList(listOf(1, 3, 5)))
    mergeAndPrint(LinkedList(listOf(1, 1, 3)), empty2)
    mergeAndPrint(LinkedList(listOf(1, 3, 5)), LinkedList(listOf(2, 4, 6)))
    mergeAndPrint(LinkedList(listOf(2, 4, 6)), LinkedList(listOf(2, 2, 6)))
}

private fun <E : Comparable<E>> mergeAndPrint(list1: LinkedList<E>, list2: LinkedList<E>) {
    val mergeList = merge(list1, list2)
    println(mergeList.joinToString())
}
