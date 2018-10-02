package cn.dong.interviews

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
            val root = binaryTree.getRoot()
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
})
