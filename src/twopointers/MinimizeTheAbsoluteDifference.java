package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/minimize-the-absolute-difference/
 *
 * Given three sorted arrays A, B and Cof not necessarily same sizes.
 Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
 i.e. minimize | max(a,b,c) - min(a,b,c) |.

 Example :
 Input:

 A : [ 1, 4, 5, 8, 10 ]
 B : [ 6, 9, 15 ]
 C : [ 2, 3, 6, 6 ]
 Output:

 1
 Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.

 */
public class MinimizeTheAbsoluteDifference {

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {

        int minAbsDiff = Integer.MAX_VALUE;

        if (A == null || B == null || C == null || A.isEmpty() || B.isEmpty() || C.isEmpty()) {
            return minAbsDiff;
        }

        int i = 0;
        int j = 0;
        int k = 0;

        // Initialize result
        //int res_i =0, res_j = 0, res_k = 0;

        while (i < A.size() && j < B.size() && k < C.size()) {
            int minimum = Math.min(C.get(k), Math.min(A.get(i), B.get(j)));
            int maximum = Math.max(C.get(k), Math.max(A.get(i), B.get(j)));

            minAbsDiff = Math.min(minAbsDiff, Math.abs(minimum - maximum));
            if (minAbsDiff == 0) {
                break;
            } else if (minimum == A.get(i)) {
                i++;
            } else if (minimum == B.get(j)) {
                j++;
            } else if (minimum == C.get(k)) {
                k++;
            }
        }
        return minAbsDiff;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 4, 5, 8, 10);
        List<Integer> B = Arrays.asList(6, 9, 15);
        List<Integer> C = Arrays.asList( 2, 3, 6, 6);

        //System.out.println(new MinimizeTheAbsoluteDifference().solve(A, B, C));
    }
}
