package twoPointers


fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    if (nums.size < 3) return result
    nums.sort() //sort the array
    for (i in 0 until nums.size) { //iterate over the array
        if (i>0 &&nums[i]==nums[i-1])continue // to avoid duplicates
        val target = 0 -nums[i]
        var left=i+1
        var right=nums.size-1
        while (left<right){
            val sum=nums[left]+nums[right]
            when{
                sum<target ->{
                    left ++
                }
                sum>target ->{
                    right --
                }
                sum==target->{
                 //sum is equal to target
                    result.add(listOf(nums[i],nums[left],nums[right]))
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]) left++; // avoid duplicates
                    while(left<right && nums[right]==nums[right+1]) right--; // avoid duplicates
                }
            }
        }
    }
    return result
}

fun main() {
    val input1 = intArrayOf(-1, 0, 1, 2, -1, -4)
    val input2 = intArrayOf()
    println(threeSum(input1))
    println(threeSum(input2))
}