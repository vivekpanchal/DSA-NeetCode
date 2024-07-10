package tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null // base case
    val temp=root.left
    root.left=root.right
    root.right=temp

    // Recursively invert the left and right subtrees
    invertTree(root.left)
    invertTree(root.right)

    return root
}


fun main() {

}