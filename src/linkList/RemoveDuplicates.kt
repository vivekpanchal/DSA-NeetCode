package linkList


/**
 * 287. Find the Duplicate Number
 * https://leetcode.com/problems/find-the-duplicate-number/
 * Using Frequency Array to store the frequency of each element
 */
fun findDuplicate(nums: IntArray): Int {
    val freq = IntArray(nums.size + 1)
    for (i in nums.indices) {
        if (freq[nums[i]] == 0) {
            freq[nums[i]] += 1
        } else {
            return nums[i]
        }
    }
    return 0
}

/**
 * 287. Find the Duplicate Number
 * using flyod's cycle detection algorithm
 */
fun findDuplicate2(nums: IntArray): Int {
    if (nums.size == 0) return 0
    var slow = nums[0]
    var fast = nums[0]

    // finding the intersection point
    while (true) {
        slow = nums[slow] // moving one step
        fast = nums[nums[fast]] // moving two steps
        if (slow == fast) break // if they meet then break the loop
    }

    // finding the entrance of the cycle
    slow = nums[0]
    while (slow != fast) {
        slow = nums[slow]
        fast = nums[fast]
    }
    return slow

}


fun main() {
val input = intArrayOf(1, 3, 4, 2, 2)
    println(findDuplicate(input)) // 2
    println(findDuplicate2(input)) // 2

}