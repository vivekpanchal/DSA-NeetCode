package dailyLeetCode


fun minIncrementForUnique(nums: IntArray): Int {
    //first sort the array
    nums.sort()

    var numTracker = 0   // Tracks the next unique number that should be set.
    var minIncrement = 0 // Counts the total increments required.

    for (num in nums) {
        numTracker = maxOf(numTracker, num)
        minIncrement += numTracker - num
        numTracker += 1 // Increment the tracker for the next number.
    }

    return minIncrement
}


fun main() {
    val input = intArrayOf(1, 3, 2, 4, 2, 5)
    println(minIncrementForUnique(input))
}