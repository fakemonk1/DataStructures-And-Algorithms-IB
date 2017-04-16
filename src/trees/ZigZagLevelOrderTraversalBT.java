package trees;

import java.util.ArrayList;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes’ values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * Example :
 * Given binary tree
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return
 * <p>
 * [
 * [3],
 * [20, 9],
 * [15, 7]
 * ]
 */

public class ZigZagLevelOrderTraversalBT {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {

        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();
        if (root == null)
            return solution;
        int order = 0;
        ArrayList<TreeNode> current = new ArrayList<>();
        current.add(root);
        while (!current.isEmpty()) {
            ArrayList<TreeNode> children = new ArrayList<>();
            for (TreeNode node : current) {
                if (node.left != null)
                    children.add(node.left);
                if (node.right != null)
                    children.add(node.right);
            }
            order = 1 - order;
            solution.add(getList(current, order));
            current = children;
        }

        return solution;
    }


    public ArrayList<Integer> getList(ArrayList<TreeNode> input, int order) {

        if (order == 0) {
            return getReverseOrder(input);
        }
        return getNormalOrder(input);
    }

    public ArrayList<Integer> getNormalOrder(ArrayList<TreeNode> input) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            answer.add(input.get(i).val);
        }
        return answer;
    }

    public ArrayList<Integer> getReverseOrder(ArrayList<TreeNode> input) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = input.size() - 1; i >= 0; i--) {
            answer.add(input.get(i).val);
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

        System.out.println(new ZigZagLevelOrderTraversalBT().zigzagLevelOrder(a1));
    }
}
