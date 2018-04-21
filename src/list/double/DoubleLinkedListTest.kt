package list.double


fun main(args: Array<String>) {
    val dll = DoubleLinkedList()

    println("\ncreate: ")
    dll.create()
    dll.show()

    println("\nisEmpty: ")
    println("result = ${dll.isEmpty()}")

    println("\ninsert: ")
    for (i in 1..10) {
        dll.insert(DoubleLinkedListNode(i))
    }
    dll.show()

    println("\nisEmpty: ")
    println("result = ${dll.isEmpty()}")

    println("\nlocate: 8")
    println("result = ${dll.locateElem(DoubleLinkedListNode(8))}")


    println("\nlength: ")
    println("result = ${dll.length()}")

    println("\ngetElem: 3")
    val e = dll.getElem(DoubleLinkedListNode(3))
    println("result = ${e?.data}")

    println("\ndelete: 1")
    dll.delete(DoubleLinkedListNode(1))
    dll.show()

    println("\ndeleteAll:")
    dll.deleteAll()
    dll.show()
}