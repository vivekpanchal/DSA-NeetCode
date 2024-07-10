Sure! I'll include the code examples in Java for each traversal method.

---

# Tree Traversals

## Introduction
Tree traversal refers to the process of visiting all the nodes of a tree data structure in a specific order. The primary tree traversal methods are:

1. **In-order Traversal**
2. **Pre-order Traversal**
3. **Post-order Traversal**
4. **Level-order Traversal**

## In-order Traversal (Left, Root, Right)
### Description
In-order traversal visits the nodes of a binary tree in ascending order. This means you first visit the left subtree, then the root node, and finally the right subtree.

### Algorithm
1. Traverse the left subtree.
2. Visit the root node.
3. Traverse the right subtree.

### Java Implementation
```java
public void inOrder(TreeNode root) {
    if (root != null) {
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
}
```

## Pre-order Traversal (Root, Left, Right)
### Description
Pre-order traversal visits the nodes of a binary tree starting from the root, then the left subtree, and finally the right subtree.

### Algorithm
1. Visit the root node.
2. Traverse the left subtree.
3. Traverse the right subtree.

### Java Implementation
```java
public void preOrder(TreeNode root) {
    if (root != null) {
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
```

## Post-order Traversal (Left, Right, Root)
### Description
Post-order traversal visits the nodes of a binary tree starting from the left subtree, then the right subtree, and finally the root node.

### Algorithm
1. Traverse the left subtree.
2. Traverse the right subtree.
3. Visit the root node.

### Java Implementation
```java
public void postOrder(TreeNode root) {
    if (root != null) {
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
}
```

## Level-order Traversal (Breadth-First)
### Description
Level-order traversal visits the nodes of a binary tree level by level, starting from the root, then moving to the next level down, and so on. This is also known as breadth-first traversal.

### Algorithm
1. Initialize a queue and add the root node to it.
2. While the queue is not empty:
    - Dequeue a node and visit it.
    - Enqueue the left child of the dequeued node.
    - Enqueue the right child of the dequeued node.

### Java Implementation
```java
import java.util.LinkedList;
import java.util.Queue;

public void levelOrder(TreeNode root) {
    if (root == null) {
        return;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
        TreeNode current = queue.poll();
        System.out.print(current.val + " ");

        if (current.left != null) {
            queue.add(current.left);
        }
        if (current.right != null) {
            queue.add(current.right);
        }
    }
}
```

## TreeNode Class (Java)
For all the above methods, you can use the following `TreeNode` class:

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
```

---

This guide should help you understand and implement different tree traversal methods in a binary tree using Java.