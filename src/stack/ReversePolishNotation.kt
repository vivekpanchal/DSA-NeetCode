package stack

import java.util.*

/**
 * leetcode Problem link : https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 * Note that division between two integers should truncate toward zero.
 * It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 */
fun evalRPN(tokens: Array<String>): Int {
    val stack= Stack<Int>()
    for (token in tokens){
        if (token =="+"||token=="-"||token=="*"||token=="/") {
            val a = stack.pop()
            val b = stack.pop()
            when (token) {
                "+" -> stack.push(b + a)
                "-" -> stack.push(b - a)
                "*" -> stack.push(b * a)
                "/" -> stack.push(b / a)
            }
        }else{
            stack.push(token.toInt())
        }
    }
    return stack.pop()
}


fun main() {
    val input = arrayOf("2", "1", "+", "3", "*")
    println(evalRPN(input))

}