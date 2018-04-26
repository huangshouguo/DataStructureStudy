package graph.list

class GraphAdjList {
    val adjList: Array<VertexNode> = Array(10) { i -> VertexNode() }
    var numVertex: Int = 0
    var numEdge: Int = 0
}