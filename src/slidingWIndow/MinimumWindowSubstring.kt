package slidingWIndow

fun minWindow(s: String, t: String): String {
    if (s.isBlank()||t.isBlank())return ""
    val countT = mutableMapOf<Char, Int>()
    val window = mutableMapOf<Char, Int>()

    // Count frequency of each character in t
    for (c in t) {
        countT[c] = countT.getOrDefault(c, 0) + 1
    }

    var have = 0
    val need = countT.size
    var res = intArrayOf(-1, -1)
    var resLen = Int.MAX_VALUE
    var left = 0

    for (right in s.indices) {
        val c = s[right]
        window[c] = window.getOrDefault(c, 0) + 1

        // If the current character's frequency matches the required frequency in t
        if (c in countT && window[c] == countT[c]) {
            have += 1
        }

        // When we have all required characters in the current window
        while (have == need) {
            // Update the result if we found a smaller window
            if ((right - left + 1) < resLen) {
                res = intArrayOf(left, right)
                resLen = right - left + 1
            }

            // Pop from the left of our window
            val leftChar = s[left]
            window[leftChar] = window[leftChar]!! - 1
            if (leftChar in countT && window[leftChar]!! < countT[leftChar]!!) {
                have -= 1
            }
            left += 1
        }
    }

    val (l, r) = res
    return if (resLen != Int.MAX_VALUE) s.substring(l, r + 1) else ""




}

fun main() {
    val input1 = "ADOBECODEBANC"
    val input2 = "ABC"
    println(minWindow(input1, input2)) // "BANC"
}