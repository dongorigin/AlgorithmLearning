package cn.dong.interviews

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.spekframework.spek2.Spek
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * @author dong on 2018/10/02.
 */
object BinaryTreeSpecs : Spek({
    group("create") {
        test("common") {
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
        test("array is empty") {
            val array = emptyArray<String>()
            val binaryTree = BinaryTree.Creator(array) { it == "#" }.create()
            assertTrue(binaryTree.isEmpty())
        }
        test("array first item is empty node") {
            val array = arrayOf("#", "a")
            val binaryTree = BinaryTree.Creator(array) { it == "#" }.create()
            assertTrue(binaryTree.isEmpty())
        }
    }
    group("traversal") {
        //    a
        //  b   c
        // # d # #
        val array = arrayOf("a", "b", "#", "d", "#", "#", "c")
        val tree = BinaryTree.Creator(array, { it == "#" }).create()

        test("pre-order traversal") {
            assertThat(tree.preOrderTraversal(), `is`(listOf("a", "b", "d", "c")))
        }
        test("in-order traversal") {
            assertThat(tree.inOrderTraversal(), `is`(listOf("b", "d", "a", "c")))
        }
        test("post-order traversal") {
            assertThat(tree.postOrderTraversal(), `is`(listOf("d", "b", "c", "a")))
        }
    }
})
