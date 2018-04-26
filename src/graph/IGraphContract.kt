package graph

interface IGraphContract<T> {
    fun create():T
    fun destroy()
    fun locateVex()
}