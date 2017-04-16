package trees;

/**
 * Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 NOTE : The path has to end on a leaf node.
 Example :

 1
 /
 2
 min depth = 2
 
 */
public class MinDepthOfBinaryTree {

    public int minDepth(TreeNode a) {
        if (a == null)
            return 0;

        if (a.left == null && a.right == null) {
            return 1;
        } else if (a.left == null) {
            return 1 + minDepth(a.right);
        } else if (a.right == null) {
            return 1 + minDepth(a.left);
        } else {
            return 1 + Math.min(minDepth(a.left), minDepth(a.right));
        }
    }
}
