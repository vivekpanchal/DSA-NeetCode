package linkList

import stack.car

/**
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null || l2 == null) return null
    val dummy = ListNode(0)
    var a = l1
    var b = l2
    var carry = 0
    var current = dummy

    while (a != null && b != null) {
        val x = if ((a != null)) a.`val` else 0
        val y = if ((b != null)) b.`val` else 0
        val sum = carry + x + y
        carry=sum/10
        current.next=ListNode(sum%10)
        current= current.next!!

        if (a!=null)a=a.next
        if (b!=null)b=b.next
    }

    if (carry > 0) {
        current.next =ListNode(carry);
    }

    return dummy.next
}


fun main() {
    val node1 = ListNode(2)
    node1.next = ListNode(4)
    node1.next!!.next = ListNode(3)
    val node2 = ListNode(5)
    node2.next = ListNode(6)
    node2.next!!.next = ListNode(4)
    val result = addTwoNumbers(node1, node2)
    var temp = result
    while (temp != null) {
        print("${temp.`val`} ")
        temp = temp.next
    }

}