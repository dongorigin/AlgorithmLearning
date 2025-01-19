package cn.dong.geektime

import cn.dong.geektime.`06LRU`.LRUByLinkedList
import kotlin.test.assertEquals
import kotlin.test.assertNull

/**
 * [06 | 链表（上）：如何实现LRU缓存淘汰算法?-数据结构与算法之美-极客时间](https://time.geekbang.org/column/article/41013)
 */
class `06LRU` {

    interface LRUCache<K, V> {
        fun add(key: K, value: V)
        fun get(key: K): V?
    }

    // One way linked list, 越靠近链表尾部的结点是越早之前访问的
    class LRUByLinkedList<K, V>(
        val max: Int
    ) : LRUCache<K, V> {

        class Node<K, V>(
            val key: K,
            var value: V,
            var next: Node<K, V>? = null
        )

        private var size: Int = 0
        private var head: Node<K, V>? = null

        init {
            assert(max >= 1)
        }

        override fun add(key: K, value: V) {
            var prev: Node<K, V>? = null
            var cur = head
            while (cur != null) {
                if (cur.key == key) {
                    // key exists
                    cur.value = value
                    // move cur to the first
                    if (cur != head) {
                        val first = head
                        head = cur
                        cur.next = first
                    }
                    return
                } else {
                    if (cur.next != null) {
                        prev = cur
                        cur = cur.next
                    } else {
                        // cur is the last one and key doesn't exist
                        if (size >= max) {
                            // remove last node
                            if (prev == null) {
                                head = null
                            } else {
                                prev.next = null
                            }
                            size--
                        }
                        break
                    }
                }
            }
            // add to the first
            val first = head
            head = Node(key, value, first)
            size++
        }

        override fun get(key: K): V? {
            var cur: Node<K, V>? = head

            while (cur != null) {
                if (cur.key == key) {
                    return cur.value
                } else {
                    cur = cur.next
                }
            }
            return null
        }
    }

}

fun main() {
    val cache = LRUByLinkedList<Int, Int>(3)

    // cache is empty
    assertNull(cache.get(1))

    cache.add(1, 1)
    assertEquals(1, cache.get(1))

    // add new value for the same key
    cache.add(1, -1)
    assertEquals(-1, cache.get(1))

    cache.add(2, 2)
    assertEquals(2, cache.get(2))
    assertEquals(-1, cache.get(1))

    cache.add(3, 3)
    assertEquals(3, cache.get(3))
    assertEquals(2, cache.get(2))
    assertEquals(-1, cache.get(1))

    cache.add(4, 4)
    assertEquals(4, cache.get(4))
    assertEquals(3, cache.get(3))
    assertEquals(2, cache.get(2))
    assertEquals(null, cache.get(1)) // the key `1` is removed because the max is 3
}