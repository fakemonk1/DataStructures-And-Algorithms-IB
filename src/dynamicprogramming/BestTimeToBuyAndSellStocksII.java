package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-ii/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * Example :
 * <p>
 * Input : [12,6,5,2,4,10,2,6,12]
 * Return : 18
 *
 *Approach: Since unlimited buying and selling is allowed,
 * if price on a particular day is greater then the lastday price
 *      buy yesterday and sell today and add it to yesterdays profit
 * else
 *       profit till today = profit till yesterday
 *
 */
public class BestTimeToBuyAndSellStocksII
{

    public int maxProfit(final List<Integer> a) {

        if (a.size() < 2) {
            return 0;
        }
        int[] totalProfitTillNow = new int[a.size()];
        totalProfitTillNow[0] = 0;


        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) > a.get(i - 1)) {
                totalProfitTillNow[i] = totalProfitTillNow[i - 1] + (a.get(i) - a.get(i - 1));
            } else {
                totalProfitTillNow[i] = totalProfitTillNow[i - 1];
            }
        }
        return totalProfitTillNow[a.size()-1];
        
    }

    public static void main(String[] args) {
        int i = new BestTimeToBuyAndSellStocksII().maxProfit(Arrays.asList(12,6,5,2,4,10,2,6,12));
        System.out.println(i);
    }

}
