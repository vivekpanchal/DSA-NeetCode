package slidingWIndow

import java.util.Stack


fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) return 0
    var p1=0
    var p2=0
    var max=0
    val set= HashSet<Char>()
    while (p2<s.length){
        if (!set.contains(s[p2])){
            set.add(s[p2])
            max= maxOf(max,p2-p1+1)
            p2++
        }else{
            set.remove(s[p1])
            p1++
        }
    }
   return max
}


fun main() {
    val input = "abcabcbb"
    println(lengthOfLongestSubstring(input)) // 3
}