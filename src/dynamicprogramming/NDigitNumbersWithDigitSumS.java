package dynamicprogramming;

/**
 * https://www.interviewbit.com/problems/n-digit-numbers-with-digit-sum-s/
 *
 * Find out the number of N digit numbers, whose digits on being added equals to a given number S. Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.

 Since the answer can be large, output answer modulo 1000000007

 ****

 N = 2, S = 4
 Valid numbers are {22, 31, 13, 40}
 Hence output 4.

 */

public class NDigitNumbersWithDigitSumS {
    int[][] dp;
    public final Integer MOD = 1000000007;

    //This function will take 0 at first place, that is why not directly called
    private int findModified(int digits, int sum) {

        if (digits == 0 && sum == 0) {
            return 1;
        } else if (digits < 1 || sum <0) {
            return 0;
        }else if (dp[digits][sum] == -1) {
            int answer = 0;

            for (int i = 0; i <= 9; i++) {
                answer = (answer % MOD  + findModified(digits - 1, sum - i)) % MOD;
            }
            dp[digits][sum] = answer;
        }
        return dp[digits][sum];
    }

    //This function will not take 0 at first place. This is mainly a wrapper over findModified. It
    // explicitly handles leading digit and call findModified() for remaining digits.
    public int solve(int digits, int sum) {
        dp = new int[digits + 1][sum + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        if (digits < 1) {
            return 0;
        } else if (digits == 1) {
            return findModified(digits, sum);
        } else {
            int answer = 0;
            for (int i = 1; i <= 9; i++) {
                answer = (answer % MOD + findModified(digits - 1, sum - i)) % MOD;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(new NDigitNumbersWithDigitSumS().solve(75, 22));
    }
}