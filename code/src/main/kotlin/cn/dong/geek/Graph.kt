package cn.dong.geek

import java.util.*

/**
 * 顶点编号从 0 到 [vertexCount]-1 连续
 *
 * @author dong on 2021/12/04.
 */
class Graph(private val vertexCount: Int) {

    private val adjacencyList: Array<LinkedList<Int>> = Array(vertexCount) { LinkedList() }

    fun addEdge(s: Int, t: Int) {
        require(s < vertexCount && t < vertexCount)

        adjacencyList[s].add(t)
        adjacencyList[t].add(s)
    }

    override fun toString(): String {
        return adjacencyList.contentToString()
    }

    /** 利用 Queue 先进先出的特性 */
    fun breadthFirstSearch(start: Int, target: Int): IntArray {
        require(start < vertexCount && target < vertexCount)

        val visited = BooleanArray(vertexCount)
        val nextQueue: Queue<Int> = LinkedList()
        val prevArray = Array(vertexCount) { -1 }

        visited[start] = true
        nextQueue.offer(start)

        while (nextQueue.size > 0) {
            val current = nextQueue.poll()
            for (next in adjacencyList[current]) {
                if (visited[next]) continue
                visited[next] = true
                prevArray[next] = current
                if (next == target) {
                    return prevToPath(prevArray, next)
                } else {
                    nextQueue.offer(next)
                }
            }
        }
        return IntArray(0)
    }

    private fun prevToPath(prevArray: Array<Int>, end: Int): IntArray {
        val path = mutableListOf<Int>()
        path.add(end)
        var prev = prevArray[end]
        while (prev != -1) {
            path.add(prev)
            prev = prevArray[prev]
        }
        return path.reversed().toIntArray()
    }

    fun depthFirstSearch(start: Int, target: Int): IntArray {
        val visited = BooleanArray(vertexCount)
        val prev = Array(vertexCount) { -1 }
        val result = innerDfs(start, target, visited, prev)
        return if (result) {
            prevToPath(prev, target)
        } else {
            IntArray(0)
        }
    }

    // 先实现，再优化
    /** true 表示找到了 */
    private fun innerDfs(start: Int, target: Int, visited: BooleanArray, prev: Array<Int>): Boolean {
        if (visited[start]) return false
        visited[start] = true
        if (start == target) return true
        for (next in adjacencyList[start]) {
            if (!visited[next]) {
                prev[next] = start
                if (innerDfs(next, target, visited, prev)) {
                    return true
                }
            }
        }
        return false
    }
}

fun main() {
    val graph = Graph(6)
    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 3)
    graph.addEdge(2, 4)
    println(graph.breadthFirstSearch(0, 4).contentToString())
    println(graph.breadthFirstSearch(2, 3).contentToString())
    println(graph.breadthFirstSearch(2, 5).contentToString())

    println(graph.depthFirstSearch(0, 4).contentToString())
    println(graph.depthFirstSearch(2, 3).contentToString())
    println(graph.depthFirstSearch(2, 5).contentToString())
}
