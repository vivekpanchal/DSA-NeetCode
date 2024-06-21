package slidingWIndow

fun maxProfit(prices: IntArray): Int {
    var min=Int.MAX_VALUE
    var maxProfit=0
    for (i in prices.indices){
        min= minOf(min,prices[i])
        maxProfit= maxOf(maxProfit,prices[i]-min)
    }

    return maxProfit
}


/**
 * Brute force approach
 * Time complexity : O(n^2)
 * Space complexity : O(1)
 */
fun maxProfitBruteForce(prices: IntArray): Int {
    //using two loops
    var maxProfit = 0
    for (i in prices.indices) {
        for (j in i + 1..<prices.size) {
            if (prices[j] > prices[i]) {
                maxProfit = maxOf(maxProfit, prices[j] - prices[i])
            }
        }
    }
    return maxProfit
}


fun main() {
    val input = intArrayOf(7, 1, 5, 3, 6, 4)
    println(maxProfit(input)) // 5
    println(maxProfitBruteForce(input)) // 5
}