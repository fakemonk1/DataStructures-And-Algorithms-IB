package trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Ashish Gupta on 14/02/17.
 */

/**
 * non recursive implementation for the postorder tranversal of binary tree
 */
public class PostOrderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode a) {

        Stack<TreeNode> stack1 = new Stack();
        Stack<TreeNode> stack2 = new Stack();
        stack1.add(a);
        while (!stack1.isEmpty()) {
            TreeNode popped = stack1.pop();
            stack2.add(popped);
            if (popped.left != null)
                stack1.add(popped.left);
            if (popped.right != null)
                stack1.add(popped.right);
        }
        ArrayList<Integer> answer = new ArrayList();
        while (!stack2.isEmpty()) {
            answer.add(stack2.pop().val);
        }
        return answer;
    }

    void postOrderTraversal2(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal2(node.left);
        postOrderTraversal2(node.right);
        System.out.println(node.val);

    }

}
