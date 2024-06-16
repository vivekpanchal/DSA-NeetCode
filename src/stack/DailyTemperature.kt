package stack

import java.util.*

/**
 * Optimal solution
 * Time complexity: O(n)
 * Space complexity: O(n
 */
fun dailyTemperatures(temperatures: IntArray): IntArray {
    val result = IntArray(temperatures.size)
    val stack = Stack<Int>()

    for (i in temperatures.indices) {
        while (stack.isNotEmpty() && temperatures[i] > temperatures[stack.peek()]) {
            val index = stack.pop()
            result[index] = i - index
        }
        stack.push(i)
    }
    return result
}

/**
 * Brute force solution
 Time complexity: O(n^2)
 Space complexity: O(n)
 */
fun dailyTemperaturesBruteForce(temperatures: IntArray): IntArray {
    val result = IntArray(temperatures.size)
    for (i in temperatures.indices) {
        for (j in i + 1..<temperatures.size) {
            if (temperatures[j] > temperatures[i]) {
                result[i] = j - i
                break
            }
        }
    }
    return result
}


fun main() {
    val temperatures = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
    println(dailyTemperatures(temperatures).contentToString())
    println(dailyTemperaturesBruteForce(temperatures).contentToString())
}