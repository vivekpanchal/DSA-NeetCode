package binarySearch


fun minEatingSpeed(piles: IntArray, h: Int): Int {
    var low = 1
    var high = piles.maxOrNull() ?: 0
    while (low < high) {
        val mid = low + (high - low) / 2
        if (canEatAll(piles, mid, h)) {
            high = mid
        } else {
            low = mid + 1
        }
    }
    return low
}

fun canEatAll(piles: IntArray, speed: Int, h: Int): Boolean {
    var hours=0
    for (pile in piles){
        hours+=(pile+speed-1)/speed // to round off
    }
    return hours<=h
}

fun main() {
    val input = intArrayOf(3, 6, 7, 11)
    val h = 8
    println(minEatingSpeed(input, h))
}