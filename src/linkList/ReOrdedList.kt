package linkList

/**
 * Reorders the given linked list by rearranging its nodes so that they follow a specific pattern.
 * The list is reordered in such a way that the first node is followed by the last node, then the second node by the second-last node, and so on.
 * This is achieved by first finding the middle of the list, reversing the second half of the list, and then merging the two halves.
 *
 * Time Complexity:
 * - Finding the middle of the list: O(n), where n is the number of nodes in the list.
 * - Reversing the second half of the list: O(n/2) which is equivalent to O(n) in terms of Big O notation.
 * - Merging the two halves: O(n).
 * Overall, the time complexity is O(n) + O(n) + O(n) = O(n).
 *
 * Space Complexity:
 * - The space complexity is O(1) as we are only using a constant amount of extra space.
 */
fun reorderList(head: ListNode?): Unit {
    if (head == null || head.next == null)
        return

    // Find the middle of the list
    var slow = head
    var fast = head.next

    while (fast != null && fast.next != null && slow != null) {
        fast = fast.next!!.next
        slow = slow.next
    }

    // Reverse the second half of the list
    var reversed = reverse(slow!!.next)
    slow.next = null

    // Merge the two halves
    var curr = head
    while (curr != null && reversed != null) {
        val next = curr.next
        val revNext = reversed.next
        curr.next = reversed
        reversed.next = next
        curr = next
        reversed = revNext
    }
}

/**
 * Reverses the given linked list and returns the new head of the list.
 *
 * Time Complexity: O(n), where n is the number of nodes in the list.
 * Space Complexity: O(1), as we are only using a constant amount of extra space.
 */
fun reverse(node: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr = node

    while (curr != null) {
        var next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }

    return prev
}

fun main() {

}