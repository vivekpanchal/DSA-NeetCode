package binarySearch


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