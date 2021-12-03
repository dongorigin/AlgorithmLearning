package cn.dong.interviews

import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * @author dong on 2018/10/02.
 */
object BinaryTreeSpecs : DescribeSpec({
    describe("create") {
        it("common") {
            val array = arrayOf("a", "b", "#", "d", "#", "#", "c")
            val binaryTree = BinaryTree.Creator(array) { it == "#" }.create()
            val root = binaryTree.root
            assertEquals("a", root!!.item)
            assertEquals("b", root.left!!.item)
            assertEquals(null, root.left!!.left)
            assertEquals("d", root.left!!.right!!.item)
            assertEquals("c", root.right!!.item)
            assertEquals(null, root.right!!.left)
            assertEquals(null, root.right!!.right)
        }
        it("array is empty") {
            val array = emptyArray<String>()
            val binaryTree = BinaryTree.Creator(array) { it == "#" }.create()
            assertTrue(binaryTree.isEmpty())
        }
        it("array first item is empty node") {
            val array = arrayOf("#", "a")
            val binaryTree = BinaryTree.Creator(array) { it == "#" }.create()
            assertTrue(binaryTree.isEmpty())
        }
    }
    describe("traversal") {
        //    a
        //   / \
        //  b   c
        // / \ / \
        // # d # #
        val array = arrayOf("a", "b", "#", "d", "#", "#", "c")
        val tree = BinaryTree.Creator(array, { it == "#" }).create()

        it("pre-order traversal") {
            val expect = listOf("a", "b", "d", "c")
//            assertThat(tree.preOrderTraversal(), `is`(expect))
//            assertThat(tree.preOrderTraversalNonRecursion(), `is`(expect))
        }
        it("in-order traversal") {
            val expect = listOf("b", "d", "a", "c")
//            assertThat(tree.inOrderTraversal(), `is`(expect))
//            assertThat(tree.inOrderTraversalNonRecursion(), `is`(expect))
        }
        it("post-order traversal") {
//            assertThat(tree.postOrderTraversal(), `is`(listOf("d", "b", "c", "a")))
        }
        it("breadth-first traversal") {
//            assertThat(tree.breadthFirstTraversal(), `is`(listOf("a", "b", "c", "d")))
        }
    }
})
