package graph.floyd

class MGraphOp {
    fun create(): MGraph {
        val graph = MGraph()
        //顶点数
        graph.numVertexes = MAX_VEX

        //边数
        graph.numEdges = 16

        //顶点
        for (i in 0 until graph.numVertexes) {
            graph.vexs[i] = "V$i"
        }

        //邻接矩阵
        //(v0, v1)
        graph.matirx[0][1] = 1
        graph.matirx[1][0] = graph.matirx[0][1]

        //(v0, v2)
        graph.matirx[0][2] = 5
        graph.matirx[2][0] = graph.matirx[0][2]

        //(v1, v2)
        graph.matirx[1][2] = 3
        graph.matirx[2][1] = graph.matirx[1][2]

        //(v1, v3)
        graph.matirx[1][3] = 7
        graph.matirx[3][1] = graph.matirx[1][3]

        //(v1, v4)
        graph.matirx[1][4] = 5
        graph.matirx[4][1] = graph.matirx[1][4]

        //(v2, v4)
        graph.matirx[2][4] = 1
        graph.matirx[4][2] = graph.matirx[2][4]

        //(v2, v5)
        graph.matirx[2][5] = 7
        graph.matirx[5][2] = graph.matirx[2][5]

        //(v3, v4)
        graph.matirx[3][4] = 2
        graph.matirx[4][3] = graph.matirx[3][4]

        //(v3, v6)
        graph.matirx[3][6] = 3
        graph.matirx[6][3] = graph.matirx[3][6]

        //(v4, v5)
        graph.matirx[4][5] = 3
        graph.matirx[5][4] = graph.matirx[4][5]

        //(v4, v6)
        graph.matirx[4][6] = 6
        graph.matirx[6][4] = graph.matirx[4][6]

        //(v4, v7)
        graph.matirx[4][7] = 9
        graph.matirx[7][4] = graph.matirx[4][7]

        //(v5, v7)
        graph.matirx[5][7] = 5
        graph.matirx[7][5] = graph.matirx[5][7]

        //(v6, v7)
        graph.matirx[6][7] = 2
        graph.matirx[7][6] = graph.matirx[6][7]

        //(v6, v8)
        graph.matirx[6][8] = 7
        graph.matirx[8][6] = graph.matirx[6][8]

        //(v7, v8)
        graph.matirx[7][8] = 4
        graph.matirx[8][7] = graph.matirx[7][8]

        return graph
    }
}