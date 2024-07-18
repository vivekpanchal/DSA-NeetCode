package arrayHashing

/**
 * using hashmap
 * Time complexity 0(n+m)
 * Space complexity 0(n+m)
 */
fun isValidAnagram1(a:String,b:String):Boolean{
 if (a.length!=b.length)return false // if length is different then they cannot be anagram
    val mapA=HashMap<Char,Int>()
    val mapB=HashMap<Char,Int>()

   for(char in a){
       //loading map A
       mapA[char]=mapA.getOrDefault(char,0)+1
   }
    for(char in b){
        //loading map b
       mapB[char]=mapB.getOrDefault(char,0)+1
   }

    return (mapA==mapB)
}

/**
 * Optimal solution
 * Time complexity 0(n)
 * Space 0(1)
 */
fun isValidAnagram(a:String,b:String):Boolean{
    if (a.length!=b.length)return false // if length is different then they cannot be anagram

    val arr=Array(26){0} //init an array with initial size of 26 for char and all items to be 0

    for (i in a.indices){
        arr[a[i] - 'a']++
        arr[b[i] - 'a']--
    }

   return arr.all { it==0 }
}



fun main() {

    val s = "listen"
    val t = "silent"
    println(isValidAnagram(s, t))

    val s1 = "hello"
    val t1 = "bello"
    println(isValidAnagram(s1, t1))  // Output: false

}