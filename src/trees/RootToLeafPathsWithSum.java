package trees;

import java.util.ArrayList;

/**
 *Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return

 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class RootToLeafPathsWithSum {

    ArrayList<ArrayList<Integer>> solution = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
       if(root == null)
           return solution;
       pathSum(root, sum,new ArrayList<>());
       return solution;
    }

    public void pathSum(TreeNode root, int sum, ArrayList<Integer> pathTillNow) {

        if (root == null) {

        } else if (isLeaf(root) && root.val == sum) {
            ArrayList<Integer> answer = new ArrayList<>(pathTillNow);
            answer.add(root.val);
            solution.add(answer);
        } else {
            ArrayList<Integer> pathTillNow1 = new ArrayList<>(pathTillNow);
            pathTillNow1.add(root.val);
            pathSum(root.left, sum - root.val,pathTillNow1 );
            pathSum(root.right, sum - root.val,pathTillNow1 );
        }
    }


    public boolean isLeaf(TreeNode node) {
        return node.right == null && node.left == null;
    }
}
