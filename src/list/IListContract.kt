package list

interface IListContract<T> {
    fun create(): T
    fun isEmpty(): Boolean
    fun deleteAll()
    fun getElem(elem: T): T?
    fun locateElem(elem: T): Int
    fun insert(elem: T)
    fun delete(elem: T)
    fun length(): Int
    fun show()
}