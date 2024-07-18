package arrayHashing


/**
 * https://leetcode.com/problems/contains-duplicate/description/
 *
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
fun checkIfContainsDuplicate(nums:IntArray):Boolean{
     val hashset=HashSet<Int>()
    for (i in nums){
        if (!hashset.add(i)) return true
    }
    return false
}

fun main() {

    /**
     * Brute force approach will be checking if number already exists or not
     * two for loops will be used and time complexity will be 0(n*2) and space would be 0(n)
     */


    /**
     * Second Approach will be sorting which would take nLogN time
     * and checking if nebouring element is same or not
     */


    /**
     * Most optimal approach will be using hashset and add boolean if already exists
     */

    val input= intArrayOf(1,2,3,1)
    val solution= checkIfContainsDuplicate(input)
    println("is contains duplicate : $solution")


}