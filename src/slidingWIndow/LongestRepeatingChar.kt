package slidingWIndow


/**
 * This Kotlin function `characterReplacementOptimized` finds the length of the longest substring that can be obtained by replacing at most `k` characters in the input string `s`.
 *
 * - `count`: An array to keep track of the frequency of each character within the current window.
 * - `start`: Marks the beginning of the current window.
 * - `maxCount`: Stores the maximum frequency of any character within the current window.
 * - `maxLength`: Represents the maximum length of a valid substring found so far.
 *
 * The algorithm iterates through the string, expanding the window to include each character, and updates `maxCount` to reflect the highest frequency of any character within the window. If the window size minus `maxCount` exceeds `k`, the window is shrunk from the start until the condition is false. This ensures that the substring always contains at most `k` replacements. The `maxLength` is updated accordingly to reflect the longest valid substring found.
 *
 * Time Complexity: O(n), where n is the length of the string. Each character is processed once.
 * Space Complexity: O(1), as the size of the `count` array is constant and does not depend on the input size.
 */
fun characterReplacementOptimized(s: String, k: Int): Int {
    val count = IntArray(26) // Frequency array for A-Z
    var start = 0 // Start of the window
    var maxCount = 0 // Max frequency of a single character within the window
    var maxLength = 0 // Max length of the window satisfying the conditions

    for (end in s.indices) {
        val charIndex = s[end] - 'A'
        count[charIndex]++
        maxCount = maxOf(maxCount, count[charIndex])

        // If current window size minus maxCount is greater than k, shrink the window
        while (end - start + 1 - maxCount > k) {
            count[s[start] - 'A']--
            start++
        }

        maxLength = maxOf(maxLength, end - start + 1)
    }

    return maxLength
}


fun main() {
    val input = "ABAB"
    val k = 2
    println(characterReplacementOptimized(input, k)) // 4
}