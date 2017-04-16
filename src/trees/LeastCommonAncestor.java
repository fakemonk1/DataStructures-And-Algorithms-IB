package trees;

/**
 * Find the lowest common ancestor in an unordered binary tree given two values in the tree.
 * You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
 * No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
 * There are no duplicate values.
 * You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.
 */

//TODO: can be optimized

public class LeastCommonAncestor {
    public int lca(TreeNode root, int val1, int val2) {

        if (isTreeContains(root, val1) && isTreeContains(root, val2)) {

            if (isTreeContains(root.right, val1) && isTreeContains(root.right, val2)) {
                return lca(root.right, val1, val2);
            } else if (isTreeContains(root.left, val1) && isTreeContains(root.left, val2)) {
                return lca(root.left, val1, val2);
            } else {
                return root.val;
            }
        } else {
            return -1;
        }
    }

    public boolean isTreeContains(TreeNode root, int value) {
        if (root == null) {
            return false;
        }

        if (root.val == value) {
            return true;
        }
        return (isTreeContains(root.right, value) || isTreeContains(root.left, value));
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(10);
        TreeNode a2 = new TreeNode(8);
        TreeNode a3 = new TreeNode(13);
        TreeNode a4 = new TreeNode(6);
        TreeNode a5 = new TreeNode(9);
        TreeNode a6 = new TreeNode(16);
        TreeNode a7 = new TreeNode(2);
        TreeNode a8 = new TreeNode(7);

        a1.left = a2;
        a1.right = a3;

        a2.left = a4;
        a2.right = a5;

        a3.right = a6;

        a4.left = a7;
        a4.right = a8;

        System.out.println(new LeastCommonAncestor().lca(a1, 6, 8));
    }
}
