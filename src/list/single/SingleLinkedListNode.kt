package list.single

class SingleLinkedListNode {
    var data: Int = 0
    var next: SingleLinkedListNode? = null

    constructor()


    constructor(data: Int) {
        this.data = data
    }

    override fun toString(): String {
        return "SingleLinkedListNode(data=$data, next=$next)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SingleLinkedListNode

        if (data != other.data) return false
        if (next != other.next) return false

        return true
    }

    override fun hashCode(): Int {
        var result = data
        result = 31 * result + (next?.hashCode() ?: 0)
        return result
    }
}