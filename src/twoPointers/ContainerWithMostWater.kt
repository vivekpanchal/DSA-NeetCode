package twoPointers


fun maxArea(height: IntArray): Int {
    var result = 0;

    //Brute Force Approch
//    for (i in 0 until height.size) {
//        for (j in i + 1 until height.size) {
//            val area = (j - i) * minOf(height[i], height[j])
//            result= maxOf(result,area)
//        }
//    }
//    return result

    var left = 0
    var right = height.size
    while (left < right) {
        val area = (right - left) * minOf(height[left], height[right])
        result = maxOf(area, result)

        if (height[left] < height[right]) {
            left++
        } else if (height[left] > height[right]) {
            right--
        } else {
            right--
        }
    }
    return result
}


fun main() {
    val input = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    println(maxArea(input))
}