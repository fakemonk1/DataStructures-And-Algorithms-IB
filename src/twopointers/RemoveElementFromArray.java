package twopointers;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/remove-element-from-array/
 *
 * Remove Element

 Given an array and a value, remove all the instances of that value in the array.
 Also return the number of elements left in the array after the operation.
 It does not matter what is left beyond the expected length.

 Example:
 If array A is [4, 1, 1, 2, 1, 3]
 and value elem is 1,
 then new length is 3, and A is now [4, 2, 3]
 Try to do it in less than linear additional space complexity.

 */

public class RemoveElementFromArray {
        public int removeElement(ArrayList<Integer> A, int B) {
            int count = 0;
            int k = 0;
            for (int i = 0; i < A.size(); i++) {
                if (A.get(i) == B) {
                    count++;
                } else {
                    A.set(i - count, A.get(i));
                }
            }

            for (int i = 0; i < count; i++)
                A.remove(A.size() - 1);

            return A.size();
        }
    }

