package binarySearch


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


fun main() {

    val input = intArrayOf(4,5,6,7,0,1,2)
    println(findMin(input)) // 1
}