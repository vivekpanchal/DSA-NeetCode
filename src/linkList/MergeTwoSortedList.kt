package linkList

/**
 * Time complexity : O(n+m)
 * Space complexity : O(1)
 */
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val dummyHead = ListNode(0)
    var current = dummyHead
    var l1 = list1
    var l2 = list2
    while (l1 != null && l2 != null) {
        if (l1.`val` < l2.`val`) {
            //if value of l1 is less than l2
            current.next = l1
            l1 = l1.next
        } else {
            current.next = l2
            l2 = l2.next
        }
        current = current.next!!
    }
    if (l1 != null) {
        current.next = l1
    } else {
        current.next = l2
    }
    return dummyHead.next
}


/**
 * Time complexity : O(n+m)
 * Space complexity : O(n+m)
 */
fun mergeTwoListsRecursive(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1
    if (list1.`val` < list2.`val`) {
        list1.next = mergeTwoListsRecursive(list1.next, list2)
        return list1
    } else {
        list2.next = mergeTwoListsRecursive(list1, list2.next)
        return list2
    }
}



fun main() {
        val input1 = ListNode(1)
        input1.next = ListNode(2)
        input1.next!!.next = ListNode(4)
        val input2 = ListNode(1)
        input2.next = ListNode(3)
        input2.next!!.next = ListNode(4)
        val result = mergeTwoLists(input1, input2)
        var temp = result
        while (temp != null) {
            print("${temp.`val`} ")
            temp = temp.next
        }
}