package twoPointers

/**
 *  Time complexity is O(n)
 *  * Space complexity is O(n)
 */
fun isPalindrome(s: String): Boolean {
    if (s.isEmpty())return true
    val str=s.toLowerCase().filter { it.isLetterOrDigit() }
    println(str)
    var start=0
    var end=str.length-1
    while (start<end){
        if(str[start]!=str[end])return false //if start and end are not equal then return false
        start++
        end--
    }
    return true
}

/**
 * Improving space
 * Time complexity is O(n)
 * Space complexity is O(1)

 */
fun isPalindromeOptimal(s: String): Boolean {
    if (s.isEmpty())return true
    var left =0
    var right=s.length-1
    while(left<right){
        if (s[left].isLetterOrDigit() && s[right].isLetterOrDigit()) {
            if (s[left].lowercaseChar() != s[right].lowercaseChar()) return false
            left++
            right--
        } else if (!s[left].isLetterOrDigit()) {
            left++
        } else if (!s[right].isLetterOrDigit()) {
            right--
        }
    }
    return true
}


fun main() {
    val input ="A man, a plan, a canal: Panama"
    val input1="."
    println(isPalindrome(input))
}