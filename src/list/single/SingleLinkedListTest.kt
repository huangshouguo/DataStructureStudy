package list.single

fun main(args: Array<String>) {
    val sll = SingleLinkedList()

    println("\ncreate: ")
    sll.create()
    sll.show()

    println("\nisEmpty: ")
    println("result = ${sll.isEmpty()}")

    println("\ninsert: ")
    for (i in 1..10) {
        sll.insert(SingleLinkedListNode(i))
    }
    sll.show()

    println("\nisEmpty: ")
    println("result = ${sll.isEmpty()}")

    println("\nlocate: 8")
    println("result = ${sll.locateElem(SingleLinkedListNode(8))}")


    println("\nlength: ")
    println("result = ${sll.length()}")

    println("\ngetElem: 3")
    val e = sll.getElem(SingleLinkedListNode(3))
    println("result = $e")

    println("\ndelete: 1")
    sll.delete(SingleLinkedListNode(1))
    sll.show()

    println("\ndeleteAll:")
    sll.deleteAll()
    sll.show()
}