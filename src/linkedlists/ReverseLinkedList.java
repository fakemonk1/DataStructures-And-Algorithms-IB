package linkedlists;

/**
 * https://www.interviewbit.com/problems/reverse-linked-list/
 *
 * Reverse a linked list. Do it in-place and in one-pass.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL,
 * <p>
 * return 5->4->3->2->1->NULL.
 */

public class ReverseLinkedList {

    public ListNode reverseList(ListNode a) {
        if (a == null)
            return null;

        ListNode reverse = null;
        ListNode temp1 = a;


        while (temp1.next != null) {
            ListNode store = temp1.next;
            temp1.next = reverse;

            reverse = temp1;
            temp1 = store;
        }
        temp1.next = reverse;
        return temp1;
    }
}
