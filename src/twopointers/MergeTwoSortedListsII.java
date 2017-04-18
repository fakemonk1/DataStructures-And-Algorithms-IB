package twopointers;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/merge-two-sorted-lists-ii/
 *
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

 Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.
 TIP: C users, please malloc the result into a new array and return the result.
 If the number of elements initialized in A and B are m and n respectively, the resulting size of array A after your code is executed should be m + n

 Example :

 Input :
 A : [1 5 8]
 B : [6 9]

 Modified A : [1 5 6 8 9]

 */
public class MergeTwoSortedListsII {

    public void merge(ArrayList<Integer> a1, ArrayList<Integer> a2) {
        ArrayList<Integer> solution = new ArrayList<>();

        if (a1 == null && a2 == null) {
            return;
        } else if (a2 == null || a2.isEmpty()) {
            return;
        } else if (a1 == null || a1.isEmpty()) {
            a1 = a2;
            return;
        } else {
            int i = 0;
            int j = 0;
            while (i < a1.size() && j < a2.size()) {
                if (a2.get(j) < a1.get(i)) {
                    a1.add(i, a2.get(j));
                    j++;
                } else {
                    i++;
                }
            }
            if(i==a1.size()){
                for (int x = j ; x< a2.size(); x++){
                    a1.add(a2.get(x));
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList();
        a1.add(1);
        a1.add(0, 2);
        System.out.println(a1);
    }
}
