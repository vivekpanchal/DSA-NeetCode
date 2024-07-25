package tree

fun diameterOfBinaryTree(root: TreeNode?): Int {
    var maxDiameter=0
    fun dfs(node: TreeNode?): Int{
        if(node==null) return 0
        val left=dfs(node.left)
        val right=dfs(node.right)
        maxDiameter=maxOf(maxDiameter,left+right)
        return 1+maxOf(left,right)
    }
    dfs(root)
    return maxDiameter
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
    println(diameterOfBinaryTree(root))  // Output: 4
}