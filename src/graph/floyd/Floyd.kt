package graph.floyd

class Floyd {

    private val pathWightMatrix = Array(MAX_VEX) { Array(MAX_VEX) { INFINITY } }
    private val preNodeIndxMatrix = Array(MAX_VEX) { Array(MAX_VEX) { INFINITY } }

    fun floyd(graph: MGraph) {
        for (i in 0 until graph.numVertexes) {
            for (j in 0 until graph.numVertexes) {
                pathWightMatrix[i][j] = graph.matirx[i][j]
                preNodeIndxMatrix[i][j] = j
            }
        }

        for (t in 0 until graph.numVertexes) {
            for (s in 0 until graph.numVertexes) {
                for (d in 0 until graph.numVertexes) {
                    if (pathWightMatrix[s][d] > pathWightMatrix[s][t] + pathWightMatrix[t][d]) {
                        pathWightMatrix[s][d] = pathWightMatrix[s][t] + pathWightMatrix[t][d]
                        preNodeIndxMatrix[s][d] = preNodeIndxMatrix[s][t]
                    }
                }
            }
        }

        show(graph)
    }

    private fun show(graph: MGraph) {
        for (s in 0 until graph.numVertexes) {
            for (d in (s + 1) until graph.numVertexes) {
                print("target: ${graph.vexs[s]} --> ${graph.vexs[d]}, wight: ${pathWightMatrix[s][d]}")

                var k = preNodeIndxMatrix[s][d]

                print(", path: ${graph.vexs[s]}")

                while (k != d) {
                    print(" --> ${graph.vexs[k]}")
                    k = preNodeIndxMatrix[k][d]
                }

                print(" --> ${graph.vexs[d]}\n")
            }
            println("")
        }
    }
}