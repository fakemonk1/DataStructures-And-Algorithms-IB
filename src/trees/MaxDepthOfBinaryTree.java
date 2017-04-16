package trees;

/**
 * Given a binary tree, find its maximum depth.

 The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to the farthest leaf node.

 NOTE : The path has to end on a leaf node.
 Example :

 1
 /
 2
 max depth = 2

 */

//TODO:  working but can be optimized to get in single iteration

public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode a) {
        if(a == null)
            return 0;

        return 1+ Math.max(maxDepth(a.left), maxDepth(a.right));
    }
}
