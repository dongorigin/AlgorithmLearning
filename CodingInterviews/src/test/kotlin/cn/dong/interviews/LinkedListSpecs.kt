package cn.dong.interviews

import org.spekframework.spek2.Spek
import kotlin.test.assertEquals

/**
 * @author dong on 2018/10/02.
 */
object LinkedListSpecs : Spek({
    val list by memoized { LinkedList<Int>() }

    group("basic") {
        test("add") {
            val expected = arrayOf(1, 3, 5)
            list.add(1)
            list.add(3)
            list.add(5)
            list.forEachIndexed { index, i ->
                assertEquals(expected[index], i)
            }
        }
        test("remove") {
            list.add(1)
            list.add(3)

            assertEquals(false, list.remove(2))
            assertEquals(2, list.size())

            assertEquals(true, list.remove(1))
            assertEquals(3, list.first())
        }
    }
})
