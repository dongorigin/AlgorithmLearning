package cn.dong.interviews

import io.kotest.core.spec.style.FunSpec
import kotlin.test.assertEquals

/**
 * @author dong on 2018/10/02.
 */
class LinkedListSpecs : FunSpec({
    var list = LinkedList<String>()

    beforeEach {
        list = LinkedList<String>()
    }

    context("a linked list") {
        test("empty") {
            assertEquals(0, list.size)
            assertEquals(true, list.isEmpty())
        }
        test("add") {
            val expected = arrayOf("a", "b", "c")
            expected.forEachIndexed { index, i ->
                list.add(i)
                assertEquals(index + 1, list.size)
            }
            list.forEachIndexed { index, i ->
                assertEquals(expected[index], i)
            }
        }
        test("add iterable") {
            val expected = listOf("a", "b", "c")
            val actual = LinkedList(expected)
            assertEquals(3, actual.size)
            actual.forEachIndexed { index, i ->
                assertEquals(expected[index], i)
            }
        }
        test("add empty iterable") {
            val expected = emptyList<String>()
            val actual = LinkedList(expected)
            assertEquals(0, actual.size)
        }
        test("remove only one") {
            // remove not present
            assertEquals(false, list.remove("a"))

            list.add("a")
            assertEquals(true, list.remove("a"))
            assertEquals(0, list.size)
            assertEquals(false, list.remove("a"))
        }
        test("remove first") {
            list.add("a")
            list.add("b")

            assertEquals(true, list.remove("a"))
            assertEquals(1, list.size)
            assertEquals("b", list.first())

            list.add("c")
            assertEquals("b", list.first())
            assertEquals("c", list.last())
        }
        test("remove last") {
            list.add("a")
            list.add("b")

            assertEquals(true, list.remove("b"))
            assertEquals("a", list.first())

            list.add("c")
            assertEquals("a", list.first())
            assertEquals("c", list.last())
        }
    }
})
