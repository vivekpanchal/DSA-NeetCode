package binarySearch

/**
 * Time complexity O(logn)
 * Space complexity O(1)
 */
fun search(nums: IntArray, target: Int): Int {
    var low=0
    var high=nums.size-1
    while (low<=high){
        val mid=low+(high-low)/2
        when{
            nums[mid]==target -> return mid

            nums[mid]<target ->{
                low=mid+1  // Target is greater so ignore left
            }
            else ->{
                high=mid-1 // target is smaller so ignore right part
            }
        }
    }
    return -1
}

fun main() {
    val input = intArrayOf(-1, 0, 3, 5, 9, 12)
    val target = 9
    println(search(input, target))

}