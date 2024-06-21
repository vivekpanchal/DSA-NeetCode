package slidingWIndow


/**
 *
 */
fun characterReplacement(s: String, k: Int): Int {
    val count = IntArray(26)
    var start = 0
    var maxCount = 0
    var maxLength = 0
    for (end in s.indices) {
        val charIndex = s[end] - 'A'
        count[charIndex]++ // count the frequency of each character
        maxCount = maxOf(maxCount, count[charIndex]) // get the maximum frequency of any character
        while (end-start +1 - maxCount > k) {
            count[s[start] - 'A']--
            start++
        }
        maxLength = maxOf(maxLength, end-start+1)
    }
   return maxLength
}


fun main() {
    val input = "ABAB"
    val k = 2
    println(characterReplacement(input, k)) // 4
}