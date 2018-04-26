package graph.dijkstra

/**
 * reference from: https://www.cnblogs.com/nigang/p/3658990.html
 *
 */
class DijkstraB {
    /**
     * 存储已经找到最短路径的顶点
     */
    val s = Array(MAX_VEX) { INFINITY }
    /**
     * 未找到最短路径的顶点
     */
    val v = Array(MAX_VEX - 1) { INFINITY }

    /**
     * 短路路径权值和
     */
    val dist = Array(MAX_VEX - 1) { INFINITY }

    fun dijkstra(graph: MGraph, source: Int) {

        //1. 初始化
        s[0] = source

        for (i in 0 until graph.numVertexes) {
            if (i == source) {
                continue
            }

            dist[i] = INFINITY
        }
    }
}