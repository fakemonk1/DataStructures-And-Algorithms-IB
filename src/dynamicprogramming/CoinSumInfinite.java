package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/coin-sum-infinite/
 * <p>
 * You are given a set of coins S. In how many ways can you make sum N assuming you have infinite amount of each coin in the set.
 * <p>
 * Note : Coins in set S will be unique. Expected space complexity of this problem is O(N).
 * <p>
 * Example :
 * <p>
 * Input :
 * S = [1, 2, 3]
 * N = 4
 * <p>
 * Return : 4
 * <p>
 * Explanation : The 4 possible ways are
 * {1, 1, 1, 1}
 * {1, 1, 2}
 * {2, 2}
 * {1, 3}
 * Note that the answer can overflow. So, give us the answer % 1000007
 */

public class CoinSumInfinite {
    public int MOD = 1000007;
    public int[][] answers;

    public int ways(List<Integer> coins, int indexExclsive, int sum) {

        if (sum == 0) {
            return 1;
        }
        if (indexExclsive == 0 || sum < 0 || coins.isEmpty()) {
            return 0;
        }

        if (answers[indexExclsive][sum] == -1) {
            int answer;
            Integer coinValue = coins.get(indexExclsive - 1);
            //not taken the coin
            int ways1 = ways(coins, indexExclsive - 1, sum);
            //taken the coin
            int ways2 = ways(coins, indexExclsive, sum - coinValue);
            answer = (ways1 % MOD + ways2 % MOD) % MOD;
            answers[indexExclsive][sum] = answer;
        }
        return answers[indexExclsive][sum];
    }


    public int coinChange2(List<Integer> a, int sum) {
        answers = new int[a.size()+1][sum+1];
        //fill array
        for (int i = 0; i < a.size()+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                answers[i][j] = -1;
            }
        }

        return ways(a, a.size(), sum);
    }

    public static void main(String[] args) {
        int ways = new CoinSumInfinite().coinChange2(Arrays.asList(18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8 ), 458);
        System.out.println(ways);
    }

}
