package trees;

import java.util.Arrays;
import java.util.List;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree.
 Example :

 Input :
 Inorder : [2, 1, 3]
 Postorder : [2, 3, 1]

 Return :
 1
 / \
 2   3
 */
public class ConstructBinaryTreeFromInorderAndPostorder {

    int index;

    public TreeNode buildTree( List<Integer> inOrder, List<Integer> postOrder) {
        index = postOrder.size() - 1;
        if (postOrder.size() == 1)
            return new TreeNode(postOrder.get(0));

        return constructTree(inOrder,postOrder, 0, postOrder.size() - 1);
    }


    public TreeNode constructTree(List<Integer> inOrder, List<Integer> postOrder, int start, int end) {

        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder.get(index--));

        if (start == end) {
            return root;
        }
        int indexInInorder = search(inOrder, start, end, root.val);

        root.right = constructTree(inOrder, postOrder, indexInInorder + 1, end);
        root.left = constructTree(inOrder, postOrder, start, indexInInorder - 1);


        return root;
    }


    public int search(List<Integer> inOrder, int strt, int end, int value) {
        int i = 0;
        for (i = strt; i <= end; i++) {
            if (inOrder.get(i) == value)
                return i;
        }
        return i;
    }

    public static void main(String[] args) {
        List<Integer> inorder = Arrays.asList(2, 1, 3);
        List<Integer> postOrder = Arrays.asList(2, 3, 1);
        System.out.println(new ConstructBinaryTreeFromInorderAndPostorder().buildTree(inorder,postOrder ));
    }
}
