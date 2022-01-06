package cn.dong.leetcode

import io.kotest.matchers.shouldBe

/**
 * [146. LRU 缓存 - 力扣（LeetCode）](https://leetcode-cn.com/problems/lru-cache/)
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * @author dong on 2022/01/06.
 */
class LRUCache(val capacity: Int) {
    private val map = mutableMapOf<Int, Node>()
    private val list = LinkList()

    fun get(key: Int): Int {
        val node = map[key]
        return if (node != null) {
            list.remove(node)
            list.addFirst(node)
            node.value
        } else {
            -1
        }
    }

    fun put(key: Int, value: Int) {
        val node = map[key]
        if (node != null) {
            node.value = value
            list.remove(node)
            list.addFirst(node)
        } else {
            val newNode = Node(key, value)
            map[key] = newNode
            list.addFirst(newNode)
            if (map.size > capacity) {
                list.removeLast().also {
                    map.remove(it.key)
                }
            }
        }
    }

    private class Node(
        val key: Int,
        var value: Int
    ) {
        var prev: Node? = null
        var next: Node? = null
        override fun toString(): String {
            return "Node(key=$key, value=$value)"
        }
    }

    private class LinkList {
        val dummyHead = Node(-1, 1)
        val dummyTail = Node(-1, 2)

        init {
            dummyHead.next = dummyTail
            dummyTail.prev = dummyHead
        }

        fun addFirst(node: Node) {
            node.prev = dummyHead
            node.next = dummyHead.next // if empty, this is dummyTail

            dummyHead.next = node
            node.next!!.prev = node
        }

        fun remove(node: Node) {
            node.next!!.prev = node.prev
            node.prev!!.next = node.next
        }

        fun removeLast(): Node {
            val node = dummyTail.prev!!
            remove(node)
            return node
        }
    }
}

fun main() {
    val lruCache = LRUCache(2)
    lruCache.get(1) shouldBe -1
    lruCache.put(1, 1)
    lruCache.put(2, 2)
    lruCache.get(1) shouldBe 1
    lruCache.put(3, 3)
    lruCache.get(2) shouldBe -1
    lruCache.put(4, 4)
    lruCache.get(1) shouldBe -1
    lruCache.get(3) shouldBe 3
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */