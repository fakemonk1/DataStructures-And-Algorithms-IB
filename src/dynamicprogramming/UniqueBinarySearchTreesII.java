package dynamicprogramming;

import java.util.Arrays;

/**
 * https://www.interviewbit.com/problems/unique-binary-search-trees-ii/
 *Given A, how many structurally unique BST’s (binary search trees) that store values 1...A?

 Example :

 Given A = 3, there are a total of 5 unique BST’s.


 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3

 */
public class UniqueBinarySearchTreesII {

    int[] dp;
    public int find(int n) {

        if (dp[n] == -1) {
            int solution = 0;
            for (int i = 1; i <= n; i++) {
                solution += find(i - 1) * find(n - i);
            }
            dp[n] = solution;
        }
        return dp[n];
    }
    public int numTrees(int i) {
        dp = new int[i + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return find(i);
    }
}
