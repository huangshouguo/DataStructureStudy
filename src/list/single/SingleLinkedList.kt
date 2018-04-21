package list.single

import list.IListContract

class SingleLinkedList : IListContract<SingleLinkedListNode> {
    private lateinit var header: SingleLinkedListNode
    private lateinit var tail: SingleLinkedListNode

    /**
     * 单向链表的创建
     *    表头和表尾相连
     */
    override fun create(): SingleLinkedListNode {
        this.header = SingleLinkedListNode()
        this.tail = SingleLinkedListNode()

        this.header.nextNode = this.tail
        this.tail.nextNode = null

        return this.header
    }

    /**
     * 是否为空表
     */
    override fun isEmpty(): Boolean {
        return this.header.nextNode == this.tail
    }

    /**
     * 删除所有元素
     */
    override fun deleteAll() {
        if (this.isEmpty()) {
            return
        }

        var node = this.header.nextNode

        while (node != this.tail) {
            val next = node!!.nextNode
            node!!.nextNode = null
            this.header.nextNode = next
            node = this.header.nextNode
        }
    }

    /**
     * 获取给定元素的节点
     */
    override fun getElem(elem: SingleLinkedListNode): SingleLinkedListNode? {
        if (this.isEmpty()) {
            return null
        }

        var node = this.header.nextNode!!
        while (node != this.tail) {
            if (node.data == elem.data) {
                return node
            }
            node = node.nextNode!!
        }

        return null
    }

    /**
     * 获取给定元素的位置
     */
    override fun locateElem(elem: SingleLinkedListNode): Int {
        if (this.isEmpty()) {
            return 0
        }

        var node = this.header.nextNode!!
        var i = 1

        while (node.nextNode != this.tail) {
            if (node.data == elem.data) {
                return i
            }
            i++
            node = node.nextNode!!
        }

        return 0
    }

    /**
     * 插入元素
     *    可分为头插法和尾插法
     */
    override fun insert(elem: SingleLinkedListNode) {
//        insertInHeader(elem)
        insertInTail(elem)
    }

    /**
     * 删除给定元素节点
     */
    override fun delete(elem: SingleLinkedListNode) {
        if (isEmpty()) {
            return
        }

        var pre = this.header
        var node = pre.nextNode
        while (node != this.tail) {
            if (node!!.data == elem.data) {
                val next = node!!.nextNode
                node!!.nextNode = null
                pre.nextNode = next
                break
            }
        }
    }

    /**
     * 获取表的长度
     */
    override fun length(): Int {
        if (this.isEmpty()) {
            return 0
        }

        var node = this.header.nextNode!!
        var length = 0

        while (node != this.tail) {
            length++
            node = node.nextNode!!
        }

        return length
    }

    /**
     * 输出链表信息
     */
    override fun show() {
        print("SingleLinkedList: header --> ")

        var node = this.header.nextNode!!
        while (node != this.tail) {
            print("${node.data} --> ")
            node = node.nextNode!!
        }

        print("tail")
        println()
    }

    /**
     * 头插法
     */
    private fun insertInHeader(elem: SingleLinkedListNode) {
        elem.nextNode = this.header.nextNode
        this.header.nextNode = elem
    }

    /**
     * 尾插法
     */
    private fun insertInTail(elem: SingleLinkedListNode) {
        var pre = this.header
        var node = pre.nextNode

        while (node != this.tail) {
            pre = node!!
            node = pre.nextNode
        }

        elem.nextNode = node
        pre.nextNode = elem
    }
}