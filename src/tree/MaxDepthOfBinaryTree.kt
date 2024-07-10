package tree

import java.util.*


/**
 * using iterative approach
 */
fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)

    var depth=0
    while(queue.isNotEmpty()){
        val size=queue.size
        for(i in 0 until size){
            val node=queue.poll()
            if(node.left!=null) queue.add(node.left)
            if(node.right!=null) queue.add(node.right)
        }
        depth++
    }
    return depth
}

fun maxDepthRecursive(root: TreeNode?): Int {
    if (root == null) return 0
    return 1 + maxOf(maxDepthRecursive(root.left), maxDepthRecursive(root.right))
}



fun main() {


}