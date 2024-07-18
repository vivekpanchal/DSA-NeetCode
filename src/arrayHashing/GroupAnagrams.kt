package arrayHashing

import java.util.*


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



