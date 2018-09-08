import java.util.*

/**
 * @author dong on 2018/09/08.
 */
fun <T> breadthFirstSearch(graph: Map<T, Array<T>>, start: T, isTarget: (T) -> Boolean): Boolean {
    val startNodes = graph[start] ?: throw IllegalArgumentException("graph[start] is null")

    val searchQueue = ArrayDeque<T>()
    val searched = mutableSetOf<T>()

    searchQueue.addAll(startNodes)
    while (searchQueue.isNotEmpty()) {
        val node = searchQueue.pop()
        if (!searched.contains(node) && isTarget(node)) {
            return true
        } else {
            graph[node]?.let { searchQueue.addAll(it) }
            searched.add(node)
        }
    }
    return false
}

fun main(args: Array<String>) {
    val graph = mutableMapOf<String, Array<String>>()
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
