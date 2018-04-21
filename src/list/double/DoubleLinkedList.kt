package list.double

import list.IListContract

class DoubleLinkedList : IListContract<DoubleLinkedListNode> {
    private lateinit var header: DoubleLinkedListNode
    private lateinit var tail: DoubleLinkedListNode

    override fun create(): DoubleLinkedListNode {
        this.header = DoubleLinkedListNode()
        this.tail = DoubleLinkedListNode()

        this.header.nextNode = this.tail
        this.tail.preNode = this.header

        return this.header
    }

    override fun isEmpty(): Boolean {
        return this.header.nextNode != null && this.header.nextNode == this.tail
    }

    override fun deleteAll() {
        if (this.isEmpty()) {
            return
        }

        var node = this.header.nextNode
        while (node != this.tail) {
            node!!.preNode = null
            val next = node!!.nextNode
            node!!.nextNode = null
            node = next
        }

        this.header.nextNode = this.tail
        this.tail.preNode = this.header
    }

    override fun getElem(elem: DoubleLinkedListNode): DoubleLinkedListNode? {
        if (isEmpty()) {
            return null
        }

        var node = this.header.nextNode
        while (node != this.tail) {
            if (node!!.data == elem.data) {
                return node
            }

            node = node.nextNode
        }

        return null
    }

    override fun locateElem(elem: DoubleLinkedListNode): Int {
        if (isEmpty()) {
            return 0
        }

        var node = this.header.nextNode
        var index = 1
        while (node != this.tail) {
            if (node!!.data == elem.data) {
                return index
            }

            index++
            node = node!!.nextNode
        }

        return 0
    }

    override fun insert(elem: DoubleLinkedListNode) {
        insertInHeader(elem)
//        insertInTail(elem)
    }

    override fun delete(elem: DoubleLinkedListNode) {
        if (isEmpty()) {
            return
        }

        var node = this.header.nextNode
        while (node != this.tail) {
            if (node!!.data == elem.data) {
                node.preNode!!.nextNode = node.nextNode
                node.nextNode!!.preNode = node.preNode

                node.preNode = null
                node.nextNode = null
                break
            }
            node = node.nextNode
        }
    }

    override fun length(): Int {
        if (isEmpty()) {
            return 0
        }

        var count = 0
        var node = this.header.nextNode
        while (node != this.tail) {
            count++
            node = node!!.nextNode
        }

        return count
    }

    override fun show() {
        print("DoubleLinkedList: header <==> ")
        var node = this.header.nextNode
        while (node != this.tail) {
            print("${node!!.data} <==> ")
            node = node!!.nextNode
        }

        print("tail")
        println()
    }

    private fun insertInHeader(elem: DoubleLinkedListNode) {
        elem.preNode = this.header
        elem.nextNode = this.header.nextNode
        this.header.nextNode = elem
        elem.nextNode!!.preNode = elem
    }

    private fun insertInTail(elem: DoubleLinkedListNode) {
        elem.nextNode = this.tail
        elem.preNode = this.tail.preNode
        elem.preNode!!.nextNode = elem
        this.tail.preNode = elem
    }
}