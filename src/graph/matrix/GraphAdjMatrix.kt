package graph.matrix

/**
 * 图的顺序存储：邻接矩阵
 */
class GraphAdjMatrix {
    /**
     * 最大顶点数
     */
    private val MAX_VERTEX = 10

    /**
     * 表示顶点的一维数组
     */
    val vertexArray: Array<String> = Array(MAX_VERTEX) { "" }

    /**
     * 表示边的二维数组，即邻接矩阵
     */
    val edgeMatrix = Array(MAX_VERTEX) { Array(MAX_VERTEX) { 0 } }

    /**
     * 顶点数
     */
    var numVertextes = 0


    /**
     * 边数
     */
    var numEdges = 0
}