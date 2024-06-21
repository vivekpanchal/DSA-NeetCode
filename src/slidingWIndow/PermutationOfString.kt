package slidingWIndow


fun checkInclusion(s1: String, s2: String): Boolean {
    val s1Frequency = IntArray(26)
    val s2Frequency = IntArray(26)
    for (i in s1.indices) {
        s1Frequency[s1[i] - 'a']++
        s2Frequency[s2[i] - 'a']++
    }
    for (i in 0..<s2.length- s1.length) {
        if (s2Frequency.contentEquals(s1Frequency))return true // if contents are equal
        s2Frequency[s2[i+s1.length] - 'a']++
        s2Frequency[s2[i] - 'a']--
    }
    return s1Frequency.contentEquals(s2Frequency)
}


/**
 * Brute force approach
 * TIme complexity : O(n^2)
 * Space complexity : O(1)
 */
fun checkInclusionBruteForce(s1: String, s2: String): Boolean {
    if (s1.length > s2.length) return false
    val s1map = IntArray(26)
    for (i in 0 until s1.length) s1map[s1[i] - 'a']++
    for (i in 0..s2.length - s1.length) {
        val s2map = IntArray(26)
        for (j in 0 until s1.length) {
            s2map[s2[i + j] - 'a']++
        }
        if (s1map.contentEquals(s2map)) return true
    }
    return false
}

fun main() {
    val input1 = "ab"
    val input2 = "eidbaooo"
    println(checkInclusion(input1, input2)) // true
    println(checkInclusionBruteForce(input1, input2)) // true

    val input3 = "ab"
    val input4 = "eidboaoo"
    println(checkInclusion(input3, input4)) // false
    println(checkInclusionBruteForce(input3, input4)) // false

    val input5 = "adc"
    val input6 = "dcda"
    println(checkInclusion(input5, input6)) // true
    println(checkInclusionBruteForce(input5, input6)) // true
}