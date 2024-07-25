package arrayHashing

import java.util.*

/**
 * The GroupAnagrams problem involves categorizing a list of strings into groups where each group consists of strings that are anagrams of each other.
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * There are two approaches implemented here:
 *
 * 1. groupAnagrams:
 *    - Uses a frequency count of each letter in a word to generate a unique key for anagram groups.
 *    - Time Complexity: O(N*K), where N is the number of strings and K is the maximum length of a string in strs.
 *    - Space Complexity: O(N*K), to store the result and the intermediate representations of strings.
 *
 * 2. groupAnagramsSorting:
 *    - Sorts each string and uses the sorted string as a key to group anagrams.
 *    - Time Complexity: O(N*K*log(K)), due to sorting each string where K is the length of the string.
 *    - Space Complexity: O(N*K), to store the result and the sorted strings.
 *
 * Both methods aim to group anagrams together by using a HashMap where the key represents the sorted version of the string or a string representing the character count.
 */
fun main() {

    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")

    println(groupAnagrams(strs))
    println(groupAnagramsSorting(strs))
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val res: HashMap<String, MutableList<String>> = hashMapOf()

    for (s in strs){
        val count = IntArray(26)
        for (c in s){
            val index = c - 'a'
            count[index]++
        }
        val keyString=count.joinToString()
        if (!res.containsKey(keyString)){
            res[keyString]= mutableListOf()
        }
        res[keyString]?.add(s)
    }

    return res.values.toList()
}




fun groupAnagramsSorting(strs: Array<String>): List<List<String>> {
    val map: MutableMap<String, MutableList<String>> = HashMap()

    for (word in strs) {
        val chars = word.toCharArray()
        Arrays.sort(chars)
        val sortedWord = String(chars)
        if (!map.containsKey(sortedWord)) {
            map[sortedWord] = ArrayList()
        }
        map[sortedWord]!!.add(word)
    }

    return ArrayList<List<String>>(map.values)
}



