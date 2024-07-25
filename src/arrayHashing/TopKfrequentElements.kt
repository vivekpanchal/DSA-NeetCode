package arrayHashing

/**
 * Problem Statement:
 * Given a non-empty array of integers, return the k most frequent elements.
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 * Example:
 * Input: nums = [1, 1, 1, 2, 2, 3], k = 2
 * Output: [1, 2]
 * Explanation: The two most frequent elements are 1 and 2, which both appear more than once.
 */
fun main() {
    val input = intArrayOf(1, 1, 6,7,6,3, 0)
    println(topKFrequent(input,2).contentToString())
}


/**
 * bucket sort
 *
 *Time Complexity :- BigO(N)
 * Space Complexity :- BigO(N)
 */
fun topKFrequent(nums: IntArray, k: Int): IntArray {
   val map= mutableMapOf<Int,Int>()
    for (num in nums){
        map[num]=map.getOrDefault(num,0)+1
    }

    // Step 2: Create buckets
    val bucket = Array<MutableList<Int>>(nums.size + 1) { mutableListOf() }
    for ((num, freq) in map) {
        bucket[freq].add(num)
    }

    val result = mutableListOf<Int>()
    for (i in bucket.size - 1 downTo 0) {
        for (num in bucket[i]) {
            result.add(num)
            if (result.size == k) {
                return result.toIntArray()
            }
        }
    }
   return result.toIntArray()

}



fun topKFrequentBruteForce(nums: IntArray, k: Int): IntArray {
    // Step 1: Count frequencies
    val frequencyMap = mutableMapOf<Int, Int>()
    nums.forEach { num ->
        frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
    }

    // Step 2: Create a list of entries
    val entriesList = frequencyMap.entries.toList()

    // Step 3: Sort the list based on frequency in descending order
    val sortedEntries = entriesList.sortedByDescending { it.value }

    // Step 4: Extract top k elements
    val result = IntArray(k)
    for (i in 0 until k) {
        result[i] = sortedEntries[i].key
    }

    // Step 5: Return result
    return result
}