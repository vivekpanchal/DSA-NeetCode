package binarySearch


/**
 * Optimal solution
 * Time complexity: 0(mn)
 * Space complexity: O(1)
 *
 * Note : assume it's a flattened array and apply binary search
 * mid = low + (high - low) / 2
 * mid-element = matrix[mid/n][mid%n]  where mid/n gives row and mid%n gives column index
 */
fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return false
    val m = matrix.size
    val n = matrix[0].size
    var low = 0
    var high = m * n - 1

    while (low <= high) {
        val mid = low + (high - low) / 2
        val midElement = matrix[mid / n][mid % n] // mid/n gives row and mid%n gives column index

        when {
            midElement == target -> return true
            midElement < target -> low = mid + 1
            else -> high = mid - 1
        }
    }

    return false

}


/**
 * Time complexity:  0(m*n)
 * Space complexity: O(1)
 */
fun searchMatrixBruteForce(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty()) return false
    val m = matrix.size
    val n = matrix[0].size

    for (i in 0..m) {
        for (j in 0..n) {
            if (matrix[i][j] == target) {
                return true
            }
        }
    }
    return false
}

fun main() {
    val input = arrayOf(
        intArrayOf(1, 3, 5, 7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 60)
    )
    val target = 3
    println(searchMatrix(input, target))
    println(searchMatrixBruteForce(input, target))
}