package stack

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 */


    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        backtrack(result, "", 0, 0, n)
        return result
    }

    fun backtrack(result: MutableList<String>, current: String, open: Int, close: Int, max: Int) {
        if (current.length == max * 2) {
            result.add(current)
            return
        }

        if (open < max) {
            backtrack(result, "$current(", open + 1, close, max)
        }
        if (close < open) {
            backtrack(result, "$current)", open, close + 1, max)
        }
    }


fun main() {
    println(generateParenthesis(3))
}