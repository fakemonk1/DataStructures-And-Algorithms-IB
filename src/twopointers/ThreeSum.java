package twopointers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.interviewbit.com/problems/3-sum/
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers.
 * Assume that there will only be one solution
 * Example:
 * given array S = {-1 2 1 -4},
 * and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 * <p>
 * Solution:
 * in this we assume the first pointer by looping through the given array,
 * and find the sum closest by using two pointers approach between remaining elements
 */

public class ThreeSum {

    public int threeSumClosest(ArrayList<Integer> A, int B) {
        int low, high, mid;
        Collections.sort(A);
        int n = A.size();
        int res = A.get(0) + A.get(1) + A.get(2);

        if (n == 3) {
            return res;
        }

        int sum;
        for (low = 0; low < n - 2; low++) {
            mid = low + 1;
            high = n - 1;
            int requiredTwoNumberSum = B - A.get(low);

            while (mid < high) {

                sum = A.get(mid) + A.get(high);

                if (sum == requiredTwoNumberSum)
                    return B;
                else if (sum < requiredTwoNumberSum) {
                    mid++;
                } else {
                    high--;
                }

                int diff = Math.abs(sum - requiredTwoNumberSum);
                int otherDiff = Math.abs(res - B);

                if (diff < otherDiff)
                    res = sum + A.get(low);
            }

        }
        return res;
    }
}
