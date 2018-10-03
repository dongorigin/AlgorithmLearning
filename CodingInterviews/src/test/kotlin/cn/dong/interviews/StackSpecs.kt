package cn.dong.interviews

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

/**
 * @author dong on 2018/10/03.
 */
class StackSpecs : Spek({
    val stack by memoized { Stack<String>() }

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
