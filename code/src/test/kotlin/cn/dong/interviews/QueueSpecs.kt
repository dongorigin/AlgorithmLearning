package cn.dong.interviews

import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

/**
 * @author dong on 2018/10/03.
 */
class QueueSpecs : DescribeSpec({
    var queue = Queue<Int>()

    beforeEach {
        queue = Queue<Int>()
    }

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
