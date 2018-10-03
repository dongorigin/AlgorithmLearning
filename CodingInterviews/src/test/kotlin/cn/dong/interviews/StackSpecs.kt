package cn.dong.interviews

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

/**
 * @author dong on 2018/10/03.
 */
class StackSpecs : Spek({
    val stack by memoized { Stack<Int>() }

    describe("a stack") {
        it("empty pop") {
            assertFailsWith(NoSuchElementException::class) { stack.pop() }
        }
        it("push one item and pop") {
            assertEquals(true, stack.isEmpty())
            stack.push(5)
            assertEquals(1, stack.size)
            assertEquals(5, stack.pop())
            assertFailsWith(NoSuchElementException::class) { stack.pop() }
        }
        it("push two item and pop") {
            stack.push(1)
            stack.push(2)
            assertEquals(2, stack.pop())
            assertEquals(1, stack.pop())
            assertFailsWith(NoSuchElementException::class) { stack.pop() }
        }
    }
})
