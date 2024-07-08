package linkList




fun mergeTwoSortedList(l1:ListNode?, l2: ListNode?): ListNode? {
    val dummyHead = ListNode(0)
    var current = dummyHead
    var list1 = l1
    var list2 = l2
    while (list1 != null && list2 != null) {
        if (list1.`val` < list2.`val`) {
            //if value of list1 is less than list2
            current.next = list1
            list1 = list1.next
        } else {
            current.next = list2
            list2 = list2.next
        }
        current = current.next!!
    }
    if (list1 != null) {
        current.next = list1
    } else {
        current.next = list2
    }
    return dummyHead.next
}


fun partitionAndMerge(start:Int, end:Int, listNodes: Array<ListNode?>):ListNode?{
    if (start>end) return null
    if (start==end) return listNodes[start]
    val mid = (start+end)/2
    val l1 = partitionAndMerge(start,mid,listNodes)
    val l2 = partitionAndMerge(mid+1,end,listNodes)
    return mergeTwoSortedList(l1,l2)
}



fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val k=lists.size
    return partitionAndMerge(0,k-1,lists)
}



fun main() {

}