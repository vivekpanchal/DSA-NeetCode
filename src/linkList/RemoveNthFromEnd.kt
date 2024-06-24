package linkList

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head==null)return head
    var prev :ListNode ?=null
    var curr=head
    while (curr!=null){
        prev=curr
        curr=curr.next
    }
    println("prev ${prev?.`val`}")

    return curr
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