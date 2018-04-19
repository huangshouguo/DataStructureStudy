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

        this.header.next = this.tail
        this.tail.next = null

        return this.header
    }

    /**
     * 是否为空表
     */
    override fun isEmpty(): Boolean {
        return this.header.next == null || this.header.next!!.next == null
    }

    /**
     * 删除所有元素
     */
    override fun deleteAll() {
        if (this.isEmpty()) {
            return
        }

        var n = this.header
        var nn = n.next!!

        while (nn.next != null) {
            n.next = null
            n = nn
            nn = n.next!!
        }

        this.header.next = this.tail
    }

    /**
     * 获取给定元素的节点
     */
    override fun getElem(elem: SingleLinkedListNode): SingleLinkedListNode? {
        if (this.isEmpty()) {
            return null
        }

        var node = this.header.next!!
        while (node.next != null) {
            if (node.data == elem.data) {
                return node
            }
            node = node.next!!
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

        var node = this.header.next!!
        var i = 1

        while (node.next != null) {
            if (node.next != null && node.data == elem.data) {
                return i
            }
            node = node.next!!
            i++
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
        var n = this.header
        while (n.next != null && n.next!!.next != null) {
            if (n.next!!.data == elem.data) {
                n.next = n.next!!.next
            }
            n = n.next!!
        }
    }

    /**
     * 获取表的长度
     */
    override fun length(): Int {
        if (this.isEmpty()) {
            return 0
        }

        var n = this.header.next!!
        var i = 0
        while (n.next != null) {
            i++
            n = n.next!!
        }

        return i
    }

    /**
     * 输出链表信息
     */
    override fun show() {
        var n = this.header.next!!

        print("SingleLinkedList: header --> ")

        while (n.next != null) {
            print("${n.data} --> ")
            n = n.next!!
        }

        print("tail")
        println()
    }

    /**
     * 头插法
     */
    private fun insertInHeader(elem: SingleLinkedListNode) {
        elem.next = this.header.next
        this.header.next = elem
    }

    /**
     * 尾插法
     */
    private fun insertInTail(elem: SingleLinkedListNode) {
        var n = this.header
        while (n.next != null && n.next!!.next != null) {
            n = n.next!!
        }

        elem.next = n.next
        n.next = elem
    }
}