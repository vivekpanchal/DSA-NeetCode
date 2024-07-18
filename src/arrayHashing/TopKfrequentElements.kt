package arrayHashing


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