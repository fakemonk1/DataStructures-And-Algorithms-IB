package trees;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 Example :

    1
   / \
  2   2
 / \ / \
 3  4 4  3

 The above binary tree is symmetric.
 But the following is not:

 1
 / \
 2   2
 \   \
 3    3
 Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */

//TODO: can be optimized further?

public class SymmetricBinaryTree {
    public int isSymmetric(TreeNode a) {
        if (a == null) {
            return 1;
        }
        return isMirror(a.left, a.right) ? 1:0;
    }

    public boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        if (a == null & b != null)
            return false;
        if (b == null & a != null)
            return false;

        return (a.val == b.val && isMirror(a.left, b.right) && isMirror(a.right, b.left));
    }
}
