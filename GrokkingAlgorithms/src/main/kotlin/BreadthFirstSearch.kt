import java.util.*

/**
 * @author dong on 2018/09/08.
 */
fun <T> breadthFirstSearch(graph: Graph<T>, start: T, isTarget: (T) -> Boolean): List<T> {
    checkNotNull(graph[start]) { "graph[start] should not be null" }

    val searchQueue = ArrayDeque<T>()
    val searched = mutableSetOf<T>()
    val parents = mutableMapOf<T, T>()

    val addChildNodesToSearchQueue = { node: T ->
        graph[node]?.let { childNodes ->
            childNodes.forEach {
                searchQueue.add(it)
                parents[it] = node
            }
        }
    }

    addChildNodesToSearchQueue(start)
    while (searchQueue.isNotEmpty()) {
        val node = searchQueue.pop()
        if (!searched.contains(node) && isTarget(node)) {
            return findPath(parents, node)
        } else {
            addChildNodesToSearchQueue(node)
            searched.add(node)
        }
    }
    return emptyList()
}

class Graph<Node> : HashMap<Node, Array<Node>>()

private fun <T> findPath(parents: Map<T, T>, end: T): List<T> {
    val path = mutableListOf<T>()

    var node: T? = end
    while (node != null) {
        path.add(node)
        node = parents[node]
    }

    return path.reversed()
}

fun main(args: Array<String>) {
    val graph = Graph<String>()
    graph["you"] = arrayOf("alice", "bob", "claire")
    graph["bob"] = arrayOf("anuj", "peggy")
    graph["alice"] = arrayOf("peggy")
    graph["claire"] = arrayOf("thom", "jonny")
    graph["anuj"] = emptyArray()
    graph["peggy"] = emptyArray()
    graph["thom"] = emptyArray()
    graph["jonny"] = emptyArray()
    val path = breadthFirstSearch(graph, "you") { it.endsWith("m") }
    println(path)
}
