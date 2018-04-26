package graph.floyd

const val MAX_VEX = 9
const val INFINITY: Int = 10000

class MGraph {

    /**
     * 顶点数
     */
    var numVertexes: Int = 0

    /**
     * 边数
     */
    var numEdges: Int = 0

    /**
     * 顶点表
     */
    val vexs: Array<String> = Array(MAX_VEX) { "" }

    /**
     * 邻接矩阵,带权值
     */
    val matirx = Array(MAX_VEX) { Array(MAX_VEX) { INFINITY } }
}