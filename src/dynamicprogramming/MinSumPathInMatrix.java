package dynamicprogramming;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/min-sum-path-in-matrix
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.
 Example :

 Input :

 [  1 3 2
 4 3 1
 5 6 1
 ]

 Output : 8
 1 -> 3 -> 2 -> 1 -> 1
 */
public class MinSumPathInMatrix {

    int minCostValues[][];

    public int minPathSum(ArrayList<ArrayList<Integer>> a) {
        int[][] cost = new int[a.size()][a.get(0).size()];
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(0).size(); j++) {
                cost[i][j] = a.get(i).get(j);
            }
        }
        initializeAndFillArray(cost);


        return minCostHelper(cost, a.size() - 1, a.get(0).size() - 1);
    }


    public int minCostHelper(int cost[][], int m, int n) {

        //invalid accesss to array
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        if (m == 0 && n == 0)
            return cost[0][0];

        if (minCostValues[m][n] != Integer.MAX_VALUE) {
            return minCostValues[m][n];
        } else {
            int up = minCostHelper(cost, m - 1, n);
            int left = minCostHelper(cost, m, n - 1);
            int angle = minCostHelper(cost, m - 1, n - 1);
            int answer = cost[m][n] + getMinimum(up, left, angle);
            minCostValues[m][n] = answer;
            return answer;
        }
    }


    public int getMinimum(int x, int y, int z) {
        if (x < y && x < z) return x;
        if (y < x && y < z) return y;
        else return z;
    }

    public int minCost(int cost[][], int m, int n) {
        initializeAndFillArray(cost);
        int ans =  minCostHelper(cost, m, n);
        return ans;
    }
    public void initializeAndFillArray(int cost[][]) {
        minCostValues = new int[cost.length][cost[0].length];
        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost[0].length; j++) {
                minCostValues[i][j] = Integer.MAX_VALUE;
            }
        }
    }



    public static void main(String[] args) {
       /* int cost[][] = { {1, 2, 3},
            {4, 8, 2},
            {1, 5, 3} };*/
        int cost[][] = {
                {20, 29, 84, 4, 32, 60, 86, 8, 7, 37},
                {77, 69, 85, 83, 81, 78, 22, 45, 43, 63},
                {60, 21, 0, 94, 59, 88, 9, 54, 30, 80},
                {40, 78, 52, 58, 26, 84, 47, 0, 24, 60},
                {40, 17, 69, 5, 38, 5, 75, 59, 35, 26},
                {64, 41, 85, 22, 44, 25, 3, 63, 33, 13},
                {2, 21, 39, 51, 75, 70, 76, 57, 56, 22},
                {31, 45, 47, 100, 65, 10, 94, 96, 81, 14}};

        ArrayList<Integer> child = new ArrayList<>();
        child.add(1);
        ArrayList<ArrayList<Integer>> parent = new ArrayList<>();
        parent.add(child);
        int ans = new MinSumPathInMatrix().minCost(cost, 1, 1);
        System.out.println(ans);
    }
}
