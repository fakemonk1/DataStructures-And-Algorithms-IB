package heapsandmaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * https://www.interviewbit.com/problems/merge-k-sorted-lists/
 *
 Merge k sorted linked lists and return it as one sorted list.

 Example :

 1 -> 10 -> 20
 4 -> 11 -> 13
 3 -> 8 -> 9
 will result in

 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (ListNode node : a) {
            queue.add(node.val);
        }

        ListNode first = null;
        ListNode previous = null;

        while (!queue.isEmpty()) {
            Integer p = queue.poll();
            ListNode polled = new ListNode(p);
            if (previous == null) {
                previous = polled;
                first = polled;
            } else {
                previous.next = polled;
                previous = polled;
            }
        }
        return first;
    }

    static class ListNode {

        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("ListNode{");
            sb.append("x=").append(val);
            sb.append('}');
            return sb.toString();
        }
    }

}
