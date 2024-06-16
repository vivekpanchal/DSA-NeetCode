package stack

import java.util.Stack


fun isValid(s: String): Boolean {
    if (s.length % 2 != 0) return false // if odd case return false
    val stack =Stack<Char>()
    for(ch in s){
        when(ch) {
            '(' -> stack.push(')')
            '[' -> stack.push(']')
            '{' -> stack.push('}')
            else ->{
                if (stack.isEmpty()||stack.pop()!=ch){
                    return false
                }
            }
        }
    }
    return stack.isEmpty()
}

fun main() {
    println(isValid("()")) // true
    println(isValid("()[]{}")) // true
    println(isValid("(]")) // false
    println(isValid("([)]")) // false
    println(isValid("{[]}")) // true
    println(isValid("]")) // false
    println(isValid("[")) // false
    println(isValid(")")) // false
}