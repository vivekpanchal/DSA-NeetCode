package binarySearch


/**
 * Searches for a target value in a rotated sorted array.
 *
 * @param nums The input array, which is a rotated version of a sorted array.
 * @param target The value to search for in the array.
 * @return The index of the target if found; otherwise, -1.
 *
 * The function implements a modified binary search. In a standard binary search,
 * the array is assumed to be sorted in ascending order. However, in this case,
 * the array has been rotated. This means that at some pivot, the order of elements
 * is switched. For example, [4,5,6,7,0,1,2] is a sorted array rotated at the pivot index 4.
 *
 * The key insight is to determine which half of the array (left or right of the mid-point)
 * is sorted, and then check if the target lies within that sorted half. If it does,
 * the search continues in that half; otherwise, it continues in the other half.
 */

fun searchInRotated(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        when {
            nums[mid] == target -> return mid
            nums[left] <= nums[mid] -> {
                //checking the left sorted array
                if (nums[mid] < target || nums[left] < target) {
                    //mid element target se kam hai aur nums[left] bhi target se kam hai
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }

            else -> {
                //checking the right sorted array
                if (nums[mid] > target || nums[right] < target) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
        }
    }
    return -1
}


fun main() {
    val input = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val target = 0
    println(searchInRotated(input, target))
}