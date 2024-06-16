package arrayHashing


/** Brute Force Approach
 * Time Complexity: O(n log n) due to sorting.
 * Space Complexity: O(1) if we don't count the space for the input and output.
 */

fun longestConsecutive(nums: IntArray): Int {
    if (nums.isEmpty()) return 0 // if nothing is there return 0
    nums.sort() // this will take nLogN  for sorting
    var currentStreak = 1;
    var longestStreak = 1
    for (i in 1..<nums.size) {
        if (nums[i] != nums[i - 1]) { //to ensure current and prevous element is not same
            if (nums[i] == (nums[i - 1] + 1)) {
                currentStreak++
            } else {
                longestStreak = maxOf(currentStreak, longestStreak)
                currentStreak = 1
            }
        }
    }
    return maxOf(currentStreak, longestStreak)
}


/**
 * Optimal approach with
 * O(n)  time complexity
 * 0(n) space complexity
 */
fun longestConsecutiveOptimal(nums: IntArray): Int {
    if (nums.isEmpty()) return 0 // if nothing is there return 0
    val numSet = nums.toSet()
    var longestStreak = 0
    for (num in nums) { //iterate over each elements
        if (!numSet.contains(num - 1)) { //if less than this number is not present means its the start
            var currNum = num
            var currentStreak = 1

            while (numSet.contains(currNum + 1)) {
                currentStreak += 1
                currNum += 1
            }
            longestStreak = maxOf(currentStreak, longestStreak)
        }
    }
    return longestStreak
}


fun main() {
    val input = intArrayOf(100, 4, 200, 1, 3, 2)
    println(longestConsecutive(input))
    println(longestConsecutiveOptimal(input))
}