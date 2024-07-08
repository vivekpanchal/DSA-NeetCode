package linkList

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head==null)return head
    var dummy=ListNode(0)
    dummy.next=head
    var first = dummy
    var second = dummy

    for (i in 0 until n){
        first=first.next!!
    }
    while (first.next!=null){
        first=first.next!!
        second=second.next!!
    }
    second.next=second.next!!.next
    return dummy.next
}

fun main() {
    val input = ListNode(1)
    input.next = ListNode(2)
    input.next!!.next = ListNode(3)
    input.next!!.next!!.next = ListNode(4)
    input.next!!.next!!.next!!.next = ListNode(5)
    val result = removeNthFromEnd(input,2)
    var temp = result
    while (temp != null) {
        print("${temp.`val`} ")
        temp = temp.next
    }
}