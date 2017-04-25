package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/min-jumps-array/
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:A = [2,3,1,1,4], return 1 ( true )
 * A = [3,2,1,0,4], return 0 ( false ).
 * Return 0/1 for this problem
 *
 * Solution:
 * jump2 function is the StringWars for O(n) with AssignMiceToHoles Approach
 * with using DP the solution is O(n2)
 */

public class MinJumpsArray {
    int[] jumpArray;

    //this problem is O(n2) better solution is presented below for O(n)
    public int jump(List<Integer> a) {
        if (a.size() == 1)
            return 1;
        jumpArray = new int[a.size()];
        Arrays.fill(jumpArray, Integer.MAX_VALUE);
        //fill array
        int size = a.size();
        for (int i = size - 1; i >= 0; i--) {
            if (a.get(i) == 0) {
                jumpArray[i] = Integer.MAX_VALUE;
                //direct jump possible
            } else if (a.get(i) >= size - 1 - i) {
                jumpArray[i] = 1;
            } else {
                int minJumpsRequired = Integer.MAX_VALUE;
                for (int j = 1; j <= a.get(i); j++) {
                    minJumpsRequired = Math.min(minJumpsRequired, jumpArray[i + j]);
                }
                if (minJumpsRequired != Integer.MAX_VALUE)
                    jumpArray[i] = 1 + minJumpsRequired;
            }
        }

        return jumpArray[0] == Integer.MAX_VALUE ? -1 : jumpArray[0];

    }

    //O(n) SOLUTION, Greedy will work here
    public int jump2(List<Integer> a) {
        if (a.size() == 1) {
            return 0;
        }
        int currentIndex = 0;
        int maxReachedIndex = 0;
        if (a.get(0) == 0) {
            return -1;
        }
        int hops = 1;
        maxReachedIndex = currentIndex + a.get(currentIndex);
        while (maxReachedIndex < a.size() - 1) {
            hops++;
            //find maximum Reachable Index by iterating from current and maximum reachable
            //maxReachable = indexOfThat +  valueOfThat

            if (maxReachedIndex >= a.size()) {
                break;
            }
            int maximumInRange = Integer.MIN_VALUE;
            for (int j = currentIndex + 1; j <= maxReachedIndex && j < a.size(); j++) {
                if (a.get(j) != 0) {
                    maximumInRange = Math.max(maximumInRange, a.get(j) + j);
                    currentIndex = j;
                }
            }
            if (maximumInRange == Integer.MIN_VALUE) {
                return -1;
            } else {
                maxReachedIndex = maximumInRange;
            }
        }
        return hops;
    }

    public static void main(String[] args) {
        //List<Integer> list = Arrays.asList(2,3,1,1,4);
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 5, 4, 3, 6, 0, 1, 2, 3, 4, 5, 7);
        MinJumpsArray lJumpGameArray = new MinJumpsArray();
        System.out.println(lJumpGameArray.jump2(list));
    }

}
