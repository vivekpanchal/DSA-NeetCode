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

}