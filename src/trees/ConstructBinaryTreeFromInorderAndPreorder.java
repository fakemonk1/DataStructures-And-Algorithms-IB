package trees;

import java.util.Arrays;
import java.util.List;

/**
 * iven preorder and inorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree.
 Example :

 Input :
 Preorder : [1, 2, 3]
 Inorder  : [2, 1, 3]

 Return :
 1
 / \
 2   3

 */
public class ConstructBinaryTreeFromInorderAndPreorder {

    int index = 0;

    public TreeNode buildTree(List<Integer> preOrder, List<Integer> inOrder) {
        if(preOrder.size() ==1 )
            return new TreeNode(preOrder.get(0));
        return constructTree(preOrder, inOrder, 0, preOrder.size()-1);
    }


    public TreeNode constructTree(List<Integer> preOrder, List<Integer> inOrder, int start, int end) {

        if(start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder.get(index++));

        if(start == end) {
            return root;
        }
        int indexInInorder = search(inOrder, start, end, root.val);

        root.left = constructTree(preOrder, inOrder, start,indexInInorder -1);

        root.right = constructTree(preOrder, inOrder,  indexInInorder + 1, end);

        return root;
    }


    public int search(List<Integer> inOrder, int strt, int end, int value)
    {
        int i = 0;
        for (i = strt; i <= end; i++)
        {
            if (inOrder.get(i)== value)
                return i;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new ConstructBinaryTreeFromInorderAndPreorder().buildTree(Arrays.asList(2,1,6,5,3,4), Arrays.asList(5,6,1,2,3,4)));
    }
}
