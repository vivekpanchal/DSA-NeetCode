package twoPointers

fun trapBruteForce(height: IntArray): Int {
    var waterTrapped = 0
    val n = height.size

    for (i in 1 until n - 1) {
        val maxLeft = height.sliceArray(0 until i).maxOrNull() ?: 0
        val maxRight = height.sliceArray(i + 1 until n).maxOrNull() ?: 0
        waterTrapped += maxOf(0, minOf(maxLeft, maxRight) - height[i])
    }

    return waterTrapped
}



fun trapOptimal(height: IntArray): Int {
    if (height.isEmpty()) return 0

    val n = height.size
    val leftMax = IntArray(n)
    val rightMax = IntArray(n)
    var waterTrapped = 0

    leftMax[0] = height[0]
    for (i in 1 until n) {
        leftMax[i] = maxOf(leftMax[i - 1], height[i])
    }

    rightMax[n - 1] = height[n - 1]
    for (i in n - 2 downTo 0) {
        rightMax[i] = maxOf(rightMax[i + 1], height[i])
    }

    for (i in 0 until n) {
        waterTrapped += maxOf(0, minOf(leftMax[i], rightMax[i]) - height[i])
    }

    return waterTrapped
}


/**
 * Time Complexity:
 * O(n) because we process each element once.
 * Space Complexity:𝑂(1)
 * since we use only a few extra variables.
 */
fun trap(height: IntArray): Int {
    if (height.isEmpty())return 0
    var left=0
    var right=height.size-1
    var leftMax=0
    var rightMax=0
    var waterTrapped=0
    while (left<right){
        if (height[left]<height[right]){

            if (height[left]>=leftMax){
                leftMax=height[left]
            }else{
                waterTrapped+=leftMax-height[left]
            }
            left++
        }else{
            if (height[right]>=rightMax){
                rightMax=height[right]
            }else{
                waterTrapped+=rightMax-height[right]
            }
            right--
        }
    }
    return waterTrapped
}


fun main() {
 val input= intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)
    println(trapBruteForce(input)) //6
    println(trapOptimal(input)) //6
    println(trap(input)) //6
}