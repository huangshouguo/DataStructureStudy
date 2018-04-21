package list.double

data class DoubleLinkedListNode(
        var data: Int = 0,
        var preNode: DoubleLinkedListNode? = null,
        var nextNode: DoubleLinkedListNode? = null)