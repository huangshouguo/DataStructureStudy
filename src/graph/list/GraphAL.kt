package graph.list

class GraphAL {
    fun create(): GraphAdjList {
        val graph = GraphAdjList()

        //1. 顶点数
        graph.numVertex = 5

        //2. 边数
        graph.numEdge = 6

        //3. 顶点信息
        for (i in 0 until graph.numVertex) {
            graph.adjList[i].data = "v$i"
            graph.adjList[i].firstEdge = null
        }

        //4. 边信息
        //v0 --> v4
        graph.adjList[0].firstEdge = EdgeNode().also {
            it.adjVex = 4
            it.weight = 6
            it.next = null
        }

        //v1 --> v0, v1 --> v2
        graph.adjList[1].firstEdge = EdgeNode().also {
            it.adjVex = 0
            it.weight = 9
            it.next = EdgeNode().also {
                it.adjVex = 2
                it.weight = 3
                it.next = null
            }
        }

        //v2 --> v0, v2 --> v3
        graph.adjList[2].firstEdge = EdgeNode().also {
            it.adjVex = 0
            it.weight = 2
            it.next = EdgeNode().also {
                it.adjVex = 3
                it.weight = 5
                it.next = null
            }
        }

        //v3 --> v4
        graph.adjList[3].firstEdge = EdgeNode().also {
            it.adjVex = 4
            it.weight = 1
            it.next = null
        }

        //v4 none
        return graph
    }

    fun dfs(){

    }
}