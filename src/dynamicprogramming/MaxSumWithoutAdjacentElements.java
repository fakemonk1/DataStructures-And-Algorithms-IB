package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Chttps://www.interviewbit.com/problems/max-sum-without-adjacent-elements/
 * Given a 2 * N Grid of numbers, choose numbers such that the sum of the numbers
 * is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.
 * Example:
 * Grid:
 * 1 2 3 4
 * 2 3 4 5
 * so we will choose
 * 3 and 5 so sum will be 3 + 5 = 8
 * <p>
 * <p>
 * Note that you can choose more than 2 numbers
 * Approach 1:      Maintain two arrays
 * WithArray:       It saves the max value by including that value
 * WithOutArray :   It saves the max value without that value
 * <p>
 * Appraoch 2:
 * Maintain a dp[]
 * dp[i] = Math.max(dp[i-1], dp[i]+ Math.max(list1[i]), list2[i])
 */
public class MaxSumWithoutAdjacentElements {

    public int getMaxSum(List<Integer> list1, List<Integer> list2) {
        if (list1.isEmpty() && list2.isEmpty()) {
            return 0;
        }
        if (list1.size() == 1 && list2.size() == 1) {
            return Math.max(list1.get(0), list2.get(0));
        }

        int[] maxSumWith = new int[list1.size()];
        int[] maxSumWithOut = new int[list1.size()];

        maxSumWith[0] = Math.max(list1.get(0), list2.get(0));
        maxSumWithOut[0] = 0;

        for (int i = 1; i < list1.size(); i++) {
            maxSumWith[i] = maxSumWithOut[i - 1] + Math.max(list1.get(i), list2.get(i));
            maxSumWithOut[i] = Math.max(maxSumWith[i - 1], maxSumWithOut[i - 1]);
        }

        return Math.max(maxSumWith[list1.size() - 1], maxSumWithOut[list1.size() - 1]);

    }

    public int adjacent(ArrayList<List<Integer>> a) {
        return getMaxSum(a.get(0), a.get(1));
    }

    public static void main(String[] args) {
        ArrayList<List<Integer>> a = new ArrayList<>();
        List<Integer> l1 = Arrays.asList(16, 5, 54, 55, 36, 82, 61, 77, 66, 61);
        List<Integer> l2 = Arrays.asList(31, 30, 36, 70, 9, 37, 1, 11, 68, 14);

        a.add(l1);
        a.add(l2);
        System.out.println(new MaxSumWithoutAdjacentElements().adjacent(a));
    }
}
