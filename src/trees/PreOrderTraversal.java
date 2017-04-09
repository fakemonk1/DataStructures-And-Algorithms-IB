package trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Ashish Gupta on 09/04/17.
 */
public class PreOrderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode a) {
        ArrayList<Integer> answer = new ArrayList<>();
        if (a == null)
            return answer;
        Stack<TreeNode> stack = new Stack();
        stack.add(a);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            answer.add(pop.val);
            if (pop.right != null)
                stack.add(pop.right);
            if (pop.left != null)
                stack.add(pop.left);
        }
        return answer;
    }
}
