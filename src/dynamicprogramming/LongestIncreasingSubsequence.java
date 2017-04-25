package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/longest-increasing-subsequence/
 *
 * Find the longest increasing subsequence of a given sequence.
 * In other words, find a subsequence of array in which the subsequence’s elements are in strictly increasing order,
 * and in which the subsequence is as long as possible
 * Input : [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
 * Output : 6
 */

//This solution is O(n2). There is one more approach by which we can find this in O(n logn)
//http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
public class LongestIncreasingSubsequence {

    public int getLengthOfLIS(List<Integer> list) {

        List<Integer> LIS = new ArrayList<>(list.size());

        for (int i = 0; i < list.size(); i++) {
            int lisi = 1;
            int maxTillNow = 0;
            for (int j = 0; j < i; j++) {

                if (list.get(j) < list.get(i)) {
                    if (LIS.get(j) > maxTillNow)
                    maxTillNow = LIS.get(j);
                }
            }
            lisi = lisi + maxTillNow;
            LIS.add(i, lisi );
        }

        int ans = 1;
        for (int i = 0; i < LIS.size(); i++) {
            if (LIS.get(i) > ans) {
                ans = LIS.get(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //System.out.println(new LongestIncreasingSubsequence().getLengthOfLIS(Arrays.asList( 69, 54, 19, 51, 16, 54, 64, 89, 72, 40, 31, 43, 1, 11, 82, 65, 75, 67, 25, 98, 31, 77, 55, 88, 85, 76, 35, 101, 44, 74, 29, 94, 72, 39, 20, 24, 23, 66, 16, 95, 5, 17, 54, 89, 93, 10, 7, 88, 68, 10, 11, 22, 25, 50, 18, 59, 79, 87, 7, 49, 26, 96, 27, 19, 67, 35, 50, 10, 6, 48, 38, 28, 66, 94, 60, 27, 76, 4, 43, 66, 14, 8, 78, 72, 21, 56, 34, 90, 89)));
        System.out.println(new LongestIncreasingSubsequence().getLengthOfLIS(Arrays.asList( 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)));
    }
}
