package tree

import kotlin.math.abs
import kotlin.math.max


fun isBalanced(root: TreeNode?): Boolean {
    // If the tree is empty, we can say it’s balanced...
    if (root == null) return true;
    // Height Function will return -1, when it’s an unbalanced tree...
    if (height(root) == -1) return false;
    return true;
}

// Create a function to return the “height” of a current subtree using recursion...
fun height(root: TreeNode?): Int {
    // Base case...
    if (root == null) return 0
    // Height of left subtree...
    val leftHeight = height(root.left)
    // Height of height subtree...
    val rightHight = height(root.right)
    // In case of left subtree or right subtree unbalanced, return -1...
    if (leftHeight == -1 || rightHight == -1) return -1
    // If their heights differ by more than ‘1’, return -1...
    if (abs((leftHeight - rightHight).toDouble()) > 1) return -1
    // Otherwise, return the height of this subtree as max(leftHeight, rightHight) + 1...
    return (max(leftHeight.toDouble(), rightHight.toDouble()) + 1).toInt()
}


fun main() {
    val root = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3)
            right = TreeNode(4)
        }
        right = TreeNode(2).apply {
            left = TreeNode(4)
            right = TreeNode(3)
        }
    }
    println(isBalanced(root))  // Output: true

}