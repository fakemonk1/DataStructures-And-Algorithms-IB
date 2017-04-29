package graphs;


/**
 * https://www.interviewbit.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * Convert Sorted List to Binary Search Tree
 *
 Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 Example :


 Given A : 1 -> 2 -> 3
 A height balanced BST  :

 2
 /   \
 1     3
 */
public class ConvertSortedListToBinarySearchTree {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    ListNode head;

    public TreeNode sortedListToBST(ListNode listNode) {
        int N = getLength(listNode);
        head = listNode;
        return convertToBSTUtil(N);
    }

    public TreeNode convertToBSTUtil(int n) {
        if (n <= 0) {
            return null;
        }
        TreeNode current = null;

            TreeNode left = convertToBSTUtil(n / 2);
            current = new TreeNode(head.val);
            head = head.next;
            TreeNode right = convertToBSTUtil(n - n / 2 - 1);
            current.left = left;
            current.right = right;


        return current;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(44);
        ListNode a2 = new ListNode(48);
        ListNode a3 = new ListNode(50);
        ListNode a4 = new ListNode(55);
        ListNode a5 = new ListNode(100);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        System.out.println(new ConvertSortedListToBinarySearchTree().sortedListToBST(a1));
    }


    public static int getLength(ListNode node) {
        if (node == null) return 0;
        if (node.next == null) return 1;
        int length = 1;

        ListNode temp = node;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }
}
