package stack

import java.util.*

/**
 * using Stack
 * Time complexity 0(n)
 * Space complexity 0(n)
 */
fun largestRectangleArea(heights: IntArray): Int {
    val stack = Stack<Int>()
    var maxArea = 0
    val newHeight=heights+0

    for (i in newHeight.indices){
        while (stack.isNotEmpty() && newHeight[i] < newHeight[stack.peek()]){
            val height = newHeight[stack.pop()]
            val width = if (stack.isEmpty()) i else i - stack.peek() - 1
            maxArea = maxOf(maxArea, height * width)
        }
        stack.push(i)
    }
    return maxArea
}

/**
 * Time Complexity 0(n^2)
 * Space Complexity 0(n)
 */
fun largestRectangleAreaBruteForce(heights: IntArray): Int {
    var maxArea = 0
    for (i in heights.indices){
        var minHeight = heights[i]
        println("current minHeight: $minHeight")
        for (j in i..<heights.size){
            minHeight= minOf(heights[j],minHeight)
            val width=j-i +1
            maxArea= maxOf(maxArea,minHeight*width)
        }
    }
    return maxArea
}


fun main() {
    val heights = intArrayOf(1)
    println(largestRectangleArea(heights))  // Output should be 10
    println(largestRectangleAreaBruteForce(heights))  // Output should be 10
}