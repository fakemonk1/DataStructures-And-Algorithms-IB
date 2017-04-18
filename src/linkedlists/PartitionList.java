package linkedlists;

/**
 * https://www.interviewbit.com/problems/partition-list/
 * <p>
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */

public class PartitionList {
    public ListNode partition(ListNode a, int b) {
        if (a == null) return null;

        //two heads of the halves
        ListNode start1 = null;
        ListNode start2 = null;

        ListNode prev1 = null;
        ListNode prev2 = null;

        ListNode pointer = a;


        while (pointer != null) {
            ListNode next = pointer.next;
            if (pointer.val < b) {
                if (prev1 == null) {
                    prev1 = pointer;
                    prev1.next = null;
                    start1 = prev1;
                } else {
                    prev1.next = pointer;
                    prev1 = pointer;
                    prev1.next = null;
                }
            } else {
                if (prev2 == null) {
                    prev2 = pointer;
                    prev2.next = null;
                    start2 = prev2;
                } else {
                    prev2.next = pointer;
                    prev2 = pointer;
                    prev2.next = null;
                }
            }
            pointer = next;
        }

        if (prev1 != null) {
            prev1.next = start2;
        } else {
            return start2;
        }

        return start1 != null ? start1 : start2;
    }

    public static void main(String[] args) {
        ListNode b1 = new ListNode(401);
        ListNode b2 = new ListNode(654);
        ListNode b3 = new ListNode(910);
        ListNode b4 = new ListNode(559);
        ListNode b5 = new ListNode(582);
        ListNode b6 = new ListNode(332);
        ListNode b7 = new ListNode(26);
        ListNode b8 = new ListNode(914);
        ListNode b9 = new ListNode(13);

        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;
        b5.next = b6;
        b6.next = b7;
        b7.next = b8;
        b8.next = b9;

        ListNode partition = new PartitionList().partition(b1, 88);
        System.out.println("");
    }
}
