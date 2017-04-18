package linkedlists;

/**
 * https://www.interviewbit.com/problems/intersection-of-linked-lists/
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.

 For example, the following two linked lists:
 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 */

public class IntersectionOfLinkedLists {

    public static ListNode getIntersectionNode(ListNode a, ListNode b) {
        int aLength = getLength(a);
        int bLength = getLength(b);
        ListNode tempA = a;
        ListNode tempB = b;
        if(aLength == 0 | bLength == 0) return null;
        if (aLength >= bLength) {
            int forward = aLength - bLength;
            int counter = 0;

            while (counter < forward) {
                tempA = tempA.next;
                counter++;
            }
        } else {
            int forward = bLength - aLength;
            int counter = 0;

            while (counter < forward) {
                tempB =tempB.next;
                counter++;
            }
        }
        while (true) {
            if (tempA == tempB)
                return tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }
    }

    public static int getLength(ListNode node) {
        if(node == null) return 0;
        if(node.next == null) return 1;
        int length = 1;

        ListNode temp = node;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }

}
