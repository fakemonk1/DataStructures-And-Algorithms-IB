package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.interviewbit.com/problems/level-order/
 *
 * Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).
 *
 */
public class LevelOrder {

    ArrayList<ArrayList<Integer>> solution = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {

        if (a == null)
            return solution;

        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.add(a);

        levelOrderHelper(queue1);
        return solution;

    }

    public void levelOrderHelper(Queue<TreeNode> queue1) {
        if (queue1.isEmpty())
            return;
        Queue<TreeNode> queue2 = new LinkedList<>();
        ArrayList<Integer> solutionChild = new ArrayList<>();
        while (!queue1.isEmpty()) {
            TreeNode polled = queue1.poll();
            solutionChild.add(polled.val);

            if (polled.left != null)
                queue2.add(polled.left);
            if (polled.right != null)
                queue2.add(polled.right);
        }
        solution.add(solutionChild);
        queue1.addAll(queue2);
        levelOrderHelper(queue1);
    }

}
