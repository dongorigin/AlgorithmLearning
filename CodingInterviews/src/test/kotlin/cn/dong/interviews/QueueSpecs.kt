package cn.dong.interviews

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

/**
 * @author dong on 2018/10/03.
 */
class QueueSpecs : Spek({
    val queue by memoized { Queue<Int>() }

    describe("a queue") {
        it("empty dequeue") {
            assertEquals(true, queue.isEmpty())
            assertEquals(0, queue.size)
            assertFailsWith(NoSuchElementException::class) { queue.dequeue() }
        }
        it("enqueue one item and dequeue") {
            queue.enqueue(5)
            assertEquals(false, queue.isEmpty())
            assertEquals(1, queue.size)

            assertEquals(5, queue.dequeue())
            assertEquals(true, queue.isEmpty())
            assertFailsWith(NoSuchElementException::class) { queue.dequeue() }
        }
        it("enqueue two item and dequeue") {
            queue.enqueue(1)
            queue.enqueue(2)
            assertEquals(2, queue.size)

            assertEquals(1, queue.dequeue())
            assertEquals(2, queue.dequeue())
            assertFailsWith(NoSuchElementException::class) { queue.dequeue() }
        }
    }
})
