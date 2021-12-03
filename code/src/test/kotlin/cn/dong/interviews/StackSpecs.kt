package cn.dong.interviews

import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

/**
 * @author dong on 2018/10/03.
 */
class StackSpecs : DescribeSpec({
    val stack = Stack<String>()

    describe("a stack") {
        it("empty pop") {
            assertEquals(true, stack.isEmpty())
            assertEquals(0, stack.size)
            assertFailsWith(NoSuchElementException::class) { stack.pop() }
        }
        it("push one item and pop") {
            stack.push("a")
            assertEquals(false, stack.isEmpty())
            assertEquals(1, stack.size)

            assertEquals("a", stack.pop())
            assertEquals(true, stack.isEmpty())
            assertFailsWith(NoSuchElementException::class) { stack.pop() }
        }
        it("push two item and pop") {
            stack.push("a")
            stack.push("b")
            assertEquals(2, stack.size)

            assertEquals("b", stack.pop())
            assertEquals(1, stack.size)

            stack.push("c")
            assertEquals(2, stack.size)

            assertEquals("c", stack.pop())
            assertEquals("a", stack.pop())
            assertFailsWith(NoSuchElementException::class) { stack.pop() }
        }
    }
})
