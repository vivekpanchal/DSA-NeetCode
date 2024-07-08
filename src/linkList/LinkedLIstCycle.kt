package linkList


/**
 * Optimised approach using Floyd's cycle detection algorithm
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
fun hasCycle(head: ListNode?): Boolean {
    if (head == null||head.next==null) return false
    var slow = head
    var fast = head.next
    while (slow != fast) {
        if (fast == null || fast.next == null) return false
        slow = slow?.next
        fast = fast.next?.next
    }
    return true
}

/**
 * using hashset to check if recently visited or not
 */
fun hasCycleBruteForce(head: ListNode?): Boolean {
    if (head == null||head.next==null) return false
    val set = HashSet<ListNode>()
    var current = head
    while (current != null) {
        if (set.contains(current)) return true
        set.add(current)
        current = current.next
    }
    return false
}

fun main() {
    val input = ListNode(1)
    input.next = ListNode(2)
    input.next?.next = ListNode(3)
    input.next?.next?.next = ListNode(4)
    input.next?.next?.next?.next = input.next

    println(hasCycle(input)) // true
}