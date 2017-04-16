package trees;

import ds.tree.TreeNode;import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * Example :
 * Given
 * <p>
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * Note that the left child of all nodes should be NULL.
 */
public class FlattenBinaryTreeToLinkedList {
    public TreeNode flatten(TreeNode root) {

        TreeNode answer = null;
        TreeNode currentAtAnswer = null;

        Stack<TreeNode> stack = new Stack();


        TreeNode current = root;

        stack.add(root);
        while (!stack.isEmpty()) {

            TreeNode pop = stack.pop();
            if (pop.right != null) {
                stack.add(pop.right);
            }
            if (pop.left != null) {
                stack.add(pop.left);
            }
            pop.left = null;
            pop.right = null;

            if (answer == null) {
                answer = pop;
                currentAtAnswer = pop;
            } else {
                currentAtAnswer.right = pop;
                currentAtAnswer = pop;
            }
            //System.out.println(answers);
        }
        return answer;
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7);
        TreeNode a8 = new TreeNode(8);

        a1.left = a2;
        a1.right = a3;

        a2.left = a4;
        a2.right = a5;

        a3.right = a6;

        a4.left = a7;
        a4.right = a8;

        System.out.println(new FlattenBinaryTreeToLinkedList().flatten(a1));
    }
}
