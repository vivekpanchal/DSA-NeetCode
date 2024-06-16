package stack

import java.util.*


class MinStack() {

    val stack=Stack<Int>()
    val min=Stack<Int>()

    fun push(`val`: Int) {
        stack.push(`val`)
        if (min.isEmpty() || `val` <= min.peek()) {
            min.push(`val`);
        }
    }

    fun pop() {
        if (stack.peek()==min.peek()){
            min.pop()
        }
        stack.pop()
    }

    fun top(): Int {
       return stack.peek()
    }

    fun getMin(): Int {
        return min.peek()
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */

fun main() {
    val input = MinStack()
    input.push(-2)
    input.push(0)
    input.push(-10)
    input.push(-3)
    input.push(-5)
    input.pop()
    println(input.min)


}