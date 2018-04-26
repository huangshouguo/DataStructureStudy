package graph.list

/**
 * 表边节点
 */
class EdgeNode {
    /**
     * 邻接点域，存储该顶点对应点下标
     */
    var adjVex: Int = 0

    /**
     * 权值，非网图可以不需要
     */
    var weight: Int = Int.MAX_VALUE

    /**
     * 链域，指向下一个邻接点
     */
    var next: EdgeNode? = null
}