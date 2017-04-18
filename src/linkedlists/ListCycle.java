package linkedlists;

/**
 * https://www.interviewbit.com/problems/list-cycle/
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Try solving it using constant additional space.

 Example :

 Input :

 ______
 |     |
 \/    |
 1 -> 2 -> 3 -> 4

 Return the node corresponding to node 3.

 */
public class ListCycle {
    public ListNode detectCycle(ListNode a) {

        if (a.next == null || a.next.next == null)
            return null;

        ListNode temp1 = a.next;
        ListNode meetup = null;
        ListNode temp2 = a.next.next;
        boolean isloop = false;

        while (temp1 != null && temp2 != null &&temp1.next != null && temp2.next != null) {
            if (temp2 == null) {
                break;
            }
            if (temp1.equals(temp2)) {
                isloop = true;
                temp1 = a;
                while (true) {
                    if (temp1.equals(temp2)) {
                        return temp1;
                    }
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }
            }
            temp1 = temp1.next;
            temp2 = temp2.next.next;
        }
        if (!isloop)
            return null;

        while (true) {
            temp1 = temp1.next;
            meetup = meetup.next;
            if (temp1.equals(meetup)) {
                return meetup;
            }
        }

    }


    public static void main(String[] args) {

        ListNode b1 = new ListNode(35);
        ListNode b2 = new ListNode(97);
        ListNode b3 = new ListNode(71);
        ListNode b4 = new ListNode(32);
        ListNode b5 = new ListNode(13);
        ListNode b6 = new ListNode(11);
        ListNode b7 = new ListNode(12);
        ListNode b8 = new ListNode(15);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;
        b5.next = b6;
        b6.next = b7;
        b7.next = b8;
        b8.next = b1;

        ListNode listNode = new ListCycle().detectCycle(b1);
        System.out.println(listNode);
    }
}
