package slidingWIndow
/**
 * This Kotlin function `maxProfit` calculates the maximum profit that can be achieved from buying and selling a stock on different days.
 * It iterates through the given array of stock prices, tracking the minimum price encountered so far and the maximum profit that can be made.
 *
 * - `min` holds the lowest price seen as we iterate, ensuring we buy at the lowest possible price.
 * - `maxProfit` keeps track of the highest profit achievable by subtracting the current minimum from the current price.
 *
 * The function returns the maximum profit possible without needing to perform transactions on the same day, thus ensuring a buy must occur before a sell.
 *
 * Time Complexity: O(n), where n is the number of days.
 * Space Complexity: O(1), as it uses a fixed amount of space.
 */
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