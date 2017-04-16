package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Note:
 * You may only use constant extra space.
 * Example :
 * <p>
 * Given the following binary tree,
 * <p>
 *    1
 *   /  \
 *  2    3
 * / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 * <p>
 *     1 -> NULL
 *   /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 * Note 1: that using recursion has memory over
 */

public class PopulateNextRightPointersTree {
    Queue<TreeLinkNode> queue = new LinkedList<>();

    public void connect(TreeLinkNode root) {

        queue.add(root);
        int height = getHeight(root);

        //TODO can be done without calculating the height
        while (height >= 0) {
            Queue<TreeLinkNode> queue2 = new LinkedList<>();
            TreeLinkNode next = null;
            while (!queue.isEmpty()) {

                TreeLinkNode polled = queue.poll();

                polled.next = next;
                if (polled.right != null)
                    queue2.add(polled.right);

                if (polled.left != null)
                    queue2.add(polled.left);
                next = polled;
            }
            queue = queue2;
            next = null;
            height--;
        }

    }

    public int getHeight(TreeLinkNode root) {
        if (root == null) {
            return -1;

        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void main(String[] args) {
        TreeLinkNode a1 = new TreeLinkNode(1);
        TreeLinkNode a2 = new TreeLinkNode(2);
        TreeLinkNode a3 = new TreeLinkNode(3);
        TreeLinkNode a4 = new TreeLinkNode(4);
        TreeLinkNode a5 = new TreeLinkNode(5);
        TreeLinkNode a6 = new TreeLinkNode(6);
        TreeLinkNode a7 = new TreeLinkNode(7);
        TreeLinkNode a8 = new TreeLinkNode(8);


        a1.left = a2;
        a1.right = a3;

        a2.left = a4;
        a2.right = a5;

        a3.right = a6;

        a4.left = a7;
        a4.right = a8;
        new PopulateNextRightPointersTree().connect(a1);
        System.out.println("");
    }

    static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}


