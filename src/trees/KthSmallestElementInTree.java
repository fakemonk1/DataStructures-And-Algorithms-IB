package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree, write a function to find the kth smallest element in the tree.

 Example :

 Input :
 2
 / \
 1   3

 and k = 2

 Return : 2

 As 2 is the second smallest element in the tree.
 NOTE : You may assume 1 <= k <= Total number of nodes in BST
 */

public class KthSmallestElementInTree {

    List<Integer> list = new ArrayList<>();

    public int kthsmallest(TreeNode root, int k) {
        return traverseInorder(root,k);
    }


    public Integer traverseInorder(TreeNode root, int k) {

        if(root == null){
            return null;
        }
        traverseInorder(root.left, k);
        list.add(root.val);
        if(list.size() >= k){
            return list.get(k-1);
        }
        traverseInorder(root.right, k);
        return null;
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(3);
        TreeNode a2 = new TreeNode(2);
        a1.left =a2;
        System.out.println(new KthSmallestElementInTree().kthsmallest(a1, 1));
    }
}
