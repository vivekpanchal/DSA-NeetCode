package binarySearch


/**
 * Problem Statement:
 * Find the minimum element in a rotated sorted array. You may assume the array does not contain duplicates.
 *
 * Example:
 * Input: nums = [4, 5, 6, 7, 0, 1, 2]
 * Output: 0
 * Explanation: The original array was [0, 1, 2, 4, 5, 6, 7] and it was rotated 4 times.
 */
fun main() {

    val input = intArrayOf(4,5,6,7,0,1,2)
    println(findMin(input)) // 1
}



fun findMin(nums: IntArray): Int {
    var left=0
    var right =nums.size-1
    while(left<right){
        val mid=left +(right-left)/2
        when{
            nums[mid]<nums[right] ->{
                right=mid
            }
            else ->{
                left =mid+1
            }
        }
    }
    return nums[left]
}


