package graph.dijkstra

class Dijkstra {

    /**
     * 存sv到各顶点最短路径到前一个顶点下标
     * 即sv到所有顶点最短路径的前一个顶点的下标
     * 比如：sv =0 求v0到v5最短路径
     * 经过计算找到最短路径为v0 --> v1 --> v2 --> v4 --> v5
     * 则pathPreNodeIdx[5] = 4
     * 因为最短路径中v5的前一个顶点是v4
     */
    val pathPreNodeIdx = Array(MAX_VEX) { -1 }

    /**
     * 存sv到各点最短路径点权值和
     * 即sv到所有顶点最短路径的权值和
     * 比如：sv =0 求v0到v5最短路径
     * 经过计算找到最短路径为v0 --> v1 --> v2 --> v4 --> v5
     * 则pathPreNodeIdx[5] = 8
     * 因为：
     * v0到v1的权值是1
     * v1到v2的权值是3
     * v2到v4的权值是1
     * v4到v5的权值是3
     *
     * 所以pathPreNodeIdx[5] = 1 + 3 + 1 +3 = 8
     */
    val pathWeight = Array(MAX_VEX) { -1 }


    fun dijkstra(graph: MGraph, sv: Int) {
        var min: Int  //最小权值的临时变量，初始化为一个非常大的值
        var k = 0 //最短路径节点下标的临时变量
        val final = Array(MAX_VEX) { 0 } //标记，final[x] =1 表示Vx到Vsv的最短路径已经找到

        //初始化数据
        for (i in 0 until graph.numVertexes) {
            final[i] = 0 //sv到各顶点最短路径均未找到
            pathPreNodeIdx[i] = INFINITY //全部初始化为无穷，表示目前没有路径，如果初始化为0容易误解
            pathWeight[i] = graph.matirx[sv][i] //sv到各顶点权值和暂时记录为sv到各顶点到权值
        }

        pathWeight[sv] = 0 //sv到自身的权值和为0
        final[sv] = 1 //sv到自身的最短路径已经找到

        /**
         * 主循环开始，每次求得Vsv到某个顶点到最短路径
         */
        for (i in 1 until graph.numVertexes) {
            min = INFINITY

            //寻找离Vsv最近的顶点
            for (j in 0 until graph.numVertexes) {
                if (final[j] == 0 && pathWeight[j] < min) {
                    k = j
                    min = pathWeight[j]
                }
            }

            final[k] = 1 //将目前找到的最近顶点标记为1

            /**
             * 基于当前找到的最短路径的顶点，查找Vsv与它们（Vk直接相连的顶点们）当前最短路径，
             * 即比较 Vsv --> Vk --> Vxx 和 Vsv --> Vxx 谁更短
             * 如果前者更短，则修正最短路径：
             * (1) 权值和
             * (2) 将Vk设为前驱
             */
            for (j in 0 until graph.numVertexes) {
                if (final[j] == 0 && min + graph.matirx[k][j] < pathWeight[j]) {
                    pathWeight[j] = min + graph.matirx[k][j]
                    pathPreNodeIdx[j] = k
                }
            }
        }

        show(graph, sv)
    }

    private fun show(graph: MGraph, sv: Int) {
        println("sv = $sv")

        for (i in 0 until this.pathPreNodeIdx.size) {
            if (i == sv) {
                continue
            }

            print("${graph.vexs[i]} --> ${graph.vexs[sv]}, weight: ${this.pathWeight[i]}, path: ${graph.vexs[i]} --> ")

            var key = this.pathPreNodeIdx[i]
            while (key != INFINITY) {
                print("${graph.vexs[key]} --> ")
                key = this.pathPreNodeIdx[key]
            }

            print(graph.vexs[sv])
            println("")
        }
    }
}