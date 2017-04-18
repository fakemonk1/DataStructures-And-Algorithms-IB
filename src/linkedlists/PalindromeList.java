package linkedlists;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/palindrome-list/
 * Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.
 * Notes:
 * - Expected solution is linear in time and constant in space.
 * For example,
 * List 1-->2-->1 is a palindrome.
 * List 1-->2-->3 is not a palindrome.
 */

public class PalindromeList {
    public static int lPalin(ListNode A) {
        List<Integer> list = new ArrayList<>();

        ListNode temp = A;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        boolean ans = true;
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            if (list.get(start).equals(list.get(end))) {
                start++;
                end--;
                continue;
            } else
                return 0;
        }
        return 1;
    }
}

