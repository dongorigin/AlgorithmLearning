package cn.dong.grokking

/**
 * @author dong on 2018/09/09.
 */
fun <Node> findShortestPath(graph: WeightedGraph<Node>, start: Node, end: Node): List<Node> {
    val costs = mutableMapOf<Node, Int>() // <node, cost>: cost from [start] to [node]
    val parents = mutableMapOf<Node, Node>() // <nodeA, nodeB>: the parent of [nodeA] is [nodeB]
    val processed = mutableSetOf<Node>()

    costs[start] = 0
    var node: Node? = start
    while (node != null) {
        val childNodes = graph[node] ?: throw IllegalArgumentException("node [$node] not exist in the graph")
        for ((childNode, cost) in childNodes) {
            // cost from [start] to [childNode]
            val oldCost = costs[childNode] ?: Int.MAX_VALUE
            val newCost = costs[node]!! + cost
            if (newCost < oldCost) {
                costs[childNode] = newCost
                parents[childNode] = node
            }
        }
        processed.add(node)
        node = findLowestCostNode(costs, processed)
    }

    return findPath(parents, end)
}

fun <Node> findLowestCostNode(costs: Map<Node, Int>, processed: Set<Node>): Node? {
    var lowestCostNode: Node? = null
    var lowestCost = Int.MAX_VALUE
    for ((node, cost) in costs) {
        if (!processed.contains(node) && cost < lowestCost) {
            lowestCostNode = node
            lowestCost = cost
        }
    }
    return lowestCostNode
}

private fun <Node> findPath(parents: Map<Node, Node>, end: Node): List<Node> {
    val path = mutableListOf<Node>()

    var node: Node? = end
    while (node != null) {
        path.add(node)
        node = parents[node]
    }

    return path.reversed()
}

class WeightedGraph<Node> : HashMap<Node, Map<Node, Int>>()

fun main(args: Array<String>) {
    val graph = WeightedGraph<String>()
    graph["start"] = mapOf("a" to 6, "b" to 2)
    graph["a"] = mapOf("fin" to 1)
    graph["b"] = mapOf("a" to 3, "fin" to 5)
    graph["fin"] = emptyMap()

    val path = findShortestPath(graph, "start", "fin")
    println(path)
}
