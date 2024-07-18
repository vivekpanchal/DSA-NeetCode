package arrayHashing

/**
 * https://leetcode.com/problems/two-sum/description/
 *Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 */

fun twoSum(nums: IntArray, target: Int): IntArray {
    val prevMap: HashMap<Int, Int> = HashMap()
    for (i in nums.indices) {
        println("indicies $i || num :${nums[i]}")
        val num = nums[i]
        val diff = target - num
        if (prevMap.containsKey(diff)) {
            return intArrayOf(prevMap[diff]!!, i)
        }
        prevMap[num] = i
    }
    return intArrayOf()
}


// this one return the actual numbers
fun twoSumNums(nums: IntArray, target: Int): IntArray {
    val prevMap: HashMap<Int, Int> = HashMap()
    for (i in nums.indices) {
        val diff = target - nums[i]
        if (prevMap.containsKey(diff)) {
            return intArrayOf(nums[prevMap[diff]!!], nums[i])
        }
        prevMap[nums[i]] = i
    }
    return intArrayOf()
}

fun main() {
    val input = intArrayOf(1, 1, 6, 3, 0)
   // println(output.contentToString())
    println(twoSumNums(input,9).contentToString())
   // println(twoSum(input,9).contentToString())
}