package graph.matrix

class GraphAM {
    fun create(): GraphAdjMatrix {
        val graph = GraphAdjMatrix()
        //1. 顶点数
        graph.numVertextes = 5

        //2. 边数
        graph.numEdges = 6

        //3. 建立顶点表
        for (i in 0 until graph.numVertextes) {
            graph.vertexArray[i] = "v$i"
        }

        //4. 建立邻接矩阵
        //(v0, v1)
        graph.edgeMatrix[0][1] = 1
        graph.edgeMatrix[1][0] = graph.edgeMatrix[0][1]

        //(v1, v2)
        graph.edgeMatrix[1][2] = 1
        graph.edgeMatrix[2][1] = graph.edgeMatrix[1][2]

        //(v2, v3)
        graph.edgeMatrix[2][3] = 1
        graph.edgeMatrix[3][2] = graph.edgeMatrix[2][3]

        //(v3, v4)
        graph.edgeMatrix[3][4] = 1
        graph.edgeMatrix[4][3] = graph.edgeMatrix[3][4]

        //(v0, v4)
        graph.edgeMatrix[0][4] = 1
        graph.edgeMatrix[4][0] = graph.edgeMatrix[0][4]

        //(v0, v2)
        graph.edgeMatrix[0][2] = 1
        graph.edgeMatrix[2][0] = graph.edgeMatrix[0][2]

        return graph
    }
}