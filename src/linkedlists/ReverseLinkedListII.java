package linkedlists;

/**
 * https://www.interviewbit.com/problems/reverse-link-list-ii/
 * <p>
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * <p>
 * return 1->4->3->2->5->NULL.
 * <p>
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list. Note 2:
 * Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question.
 */
// 1 -> 2 -> 3 -> 4 -> 5

public class ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode a, int m, int n) {

        ListNode temp = a;
        ListNode answer = a;

        ListNode end1 = null;
        ListNode end2 = null;
        ListNode startList = null;
        ListNode endList = null;

        int counter = 1;
        ListNode prev = null;
        while (temp != null) {
            if (counter == m) {
                end1 = prev;
                startList = temp;
            }
            if (counter == n) {
                end2 = temp.next;
                endList = temp;

            }
            prev = temp;
            temp = temp.next;
            counter++;
        }

        ListNode reversedList = reverseListTill(startList, endList);
        //connect now
        if (end1 != null) {
            end1.next = reversedList;
            startList.next = end2;
            answer = a;
        } else {
            answer = endList;
            startList.next = end2;
        }
        return answer;
    }

    public static ListNode reverseListTill(ListNode a, ListNode end) {
        if (a == null)
            return null;

        ListNode reverse = null;
        ListNode temp1 = a;


        while (temp1.next != end.next) {
            ListNode store = temp1.next;
            temp1.next = reverse;

            reverse = temp1;
            temp1 = store;
        }
        temp1.next = reverse;
        return temp1;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
//        ListNode a2 = new ListNode(2);
//        ListNode a3 = new ListNode(3);
//        ListNode a4 = new ListNode(4);
//        ListNode a5 = new ListNode(5);
//        a1.next = a2;
//        a2.next = a3;
//        a3.next = a4;
//        a4.next = a5;

        System.out.println(reverseBetween(a1, 1, 1));
    }
}
