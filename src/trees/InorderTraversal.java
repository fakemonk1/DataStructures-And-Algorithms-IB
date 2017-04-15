package trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Ashish Gupta on 14/02/17.
 */
public class InorderTraversal {
    /**
     * Non Recursive, uses Stack
     */
    public ArrayList<Integer> inOrderTraversal(TreeNode root) {
        ArrayList<Integer> solution = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(true){
            if(current == null){
                if(stack.isEmpty())
                    break;
                TreeNode pop = stack.pop();
                current = pop.right;
                solution.add(pop.val);
            }else {
                stack.add(current);
                current = current.left;
            }
        }
        return solution;
    }

    void inOrderTraversal2(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal2(node.left);
        System.out.println(node.val);
        inOrderTraversal2(node.right);

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

        System.out.println(new InorderTraversal().inOrderTraversal(a1));
    }
}
