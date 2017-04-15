package trees;

/**
 * Given a binary tree, determine if it is height-balanced.
 * Return : False or 0
 *
 * Definition for binary tree
 * class TreeNode {
 * int x;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { x = x; }
 * }
 */

//TODO: can be optimized further

public class HeightBalancedBinaryTree {
    public int isBalanced(TreeNode a) {
        if (a == null) {
            return 1;
        }
        int leftHeight = getHeight(a.left);
        int rightHeight = getHeight(a.right);
        return (Math.abs(leftHeight - rightHeight) <= 1 && (isBalanced(a.left) == 1) && (isBalanced(a.right) == 1)) ? 1:0;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return -1;

        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        root.right = n1;

        System.out.println(new HeightBalancedBinaryTree().isBalanced(root));
    }
}


