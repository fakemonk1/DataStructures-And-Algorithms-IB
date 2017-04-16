package trees;

import ds.tree.TreeNode;import java.util.ArrayList;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers % 1003.
 * Example :
 * <p>
 *  1
 * / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * <p>
 * Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.
 */

public class SumRootToLeafNumbers {
    public final Integer MOD = 1003;
    ArrayList<Integer> answer = new ArrayList<>();

    public int sumNumbers(TreeNode a) {
        if (a == null) {
            return 0;
        } else {
            return (int) getSum(getAllLeafNumbers(a, 0));
        }
    }

    public ArrayList<Integer> getAllLeafNumbers(TreeNode a, int previous) {

        if (a == null) {
            return answer;
        }

        if (a.left == null && a.right == null) {
            answer.add(previous * 10 + a.val);
        } else if (a.left == null) {
            getAllLeafNumbers(a.right, ((((previous * 10) % MOD) + a.val) % MOD));

        } else if (a.right == null) {
            getAllLeafNumbers(a.left, ((((previous * 10) % MOD) + a.val) % MOD));
        } else {
            getAllLeafNumbers(a.right, ((((previous * 10) % MOD) + a.val) % MOD));
            getAllLeafNumbers(a.left, ((((previous * 10) % MOD) + a.val) % MOD));
        }
        return answer;

    }

    public long getSum(ArrayList<Integer> list) {
        long answer = 0;
        for (long i : list) {
            answer = (answer % MOD + i) % MOD;
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
        System.out.println(new SumRootToLeafNumbers().sumNumbers(a1));

    }

}
