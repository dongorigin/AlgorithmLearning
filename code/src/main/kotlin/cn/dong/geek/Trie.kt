package cn.dong.geek

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * 只包含小写字母 a-z
 *
 * @author dong on 2021/12/09.
 */
class Trie {

    private class Node(val char: Char) {
        val leaf = Array<Node?>(26) { null }
        var isEnd = false
    }

    private val root = Node('0')

    fun insert(word: String) {
        var node = root
        for (char in word) {
            node = node.leaf[char.toIndex()] ?: Node(char).also {
                node.leaf[char.toIndex()] = it
            }
        }
        node.isEnd = true
    }

    fun search(word: String): Boolean {
        var node: Node? = root
        for (char in word) {
            node = node?.leaf?.get(char.toIndex()) ?: return false
        }
        return node?.isEnd == true
    }

    fun startsWith(prefix: String): Boolean {
        var node: Node? = root
        for (char in prefix) {
            node = node?.leaf?.get(char.toIndex()) ?: return false
        }
        return true
    }

    private fun Char.toIndex(): Int = this - 'a'
}

private class TrieTests : FunSpec({

    val trie = Trie()

    context("test trie") {
        trie.search("hello") shouldBe false
        trie.insert("hello")
        trie.search("hello") shouldBe true
        trie.startsWith("he") shouldBe true
    }

})
