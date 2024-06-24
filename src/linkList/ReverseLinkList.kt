package linkList

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


fun reverseList( head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr = head
    while (curr != null) {
        val nextTemp = curr.next
        curr.next = prev
        prev = curr
        curr = nextTemp
    }
    return prev
}

fun main() {
    val input = ListNode(1)
    input.next = ListNode(2)
    input.next!!.next = ListNode(3)
    input.next!!.next!!.next = ListNode(4)
    input.next!!.next!!.next!!.next = ListNode(5)
    val result = reverseList(input)
    var temp = result
    while (temp != null) {
        print("${temp.`val`} ")
        temp = temp.next
    }
}