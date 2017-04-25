package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-iii/
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete only 2 transactions (ie, buy one and sell one share of the stock 2 times).
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * Example :
 * <p>
 * Input : [1, 2, 4, 2, 5, 7, 2, 4, 9, 0]
 * <p>
 * Transaction 1 : [1-7] : Profit :6
 * Transaction 2 : [2-9] : Profit :7
 * Return : 13
 */
public class BestTimeToBuyAndSellStocksIII {

    public int maxProfit(final List<Integer> prices) {

        if (prices == null || prices.size() == 0) {
            return 0;
        }

        int[] left = new int[prices.size()]; // left[i] means highest profit in (0..i)
        int[] right = new int[prices.size()];// right[i] means highest profit in (i..last)

        // DP from left to right
        // Fill the Array like if you are given only one transaction. Like we did in Stocks1 problem
        left[0] = 0;
        int min = prices.get(0);
        for (int i = 1; i < prices.size(); i++) {
            min = Math.min(min, prices.get(i));
            left[i] = Math.max(left[i - 1], prices.get(i) - min);
        }

        // DP from right to left
        // keep the track of maximum element from the back and fill the array with the value right[i] means highest profit in (i..last)
        right[prices.size() - 1] = 0;  // DP initial state
        int max = prices.get(prices.size() - 1);
        for (int i = prices.size() - 2; i >= 0; i--) {
            max = Math.max(max, prices.get(i));
            right[i] = Math.max(right[i + 1], max - prices.get(i));
        }

        int profit = 0;
        for (int i = 0; i < prices.size(); i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }

        return profit;
    }

    public static void main(String[] args) {
        int i = new BestTimeToBuyAndSellStocksIII().maxProfit(Arrays.asList(1, 2, 4, 2, 5, 7, 2, 4, 9, 0));
        //int i = new BestTimeToBuyAndSellStocksIII().maxProfit(Arrays.asList(1,4,5,7,6,3,2,9)); //ans 13
        System.out.println(i);
    }
}
