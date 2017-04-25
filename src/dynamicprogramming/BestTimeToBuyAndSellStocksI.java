package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-i/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit
 *
 Example :
 Input : [2,10, 1, 6, 12, 0]
 Return :  11

 Approach: start processing from the start, calculate the profit on that day by using minTillThatDay and maintain a globle maxProfit variable.
 */
public class BestTimeToBuyAndSellStocksI {

    public int maxProfit(final List<Integer> a) {

        if (a.size() < 2) {
            return 0;
        }
        int minimumTillNow = a.get(0);
        int maxProfitTillNow = 0;
        for (int i = 1; i < a.size(); i++) {
            int currentValue  = a.get(i);
            int currentProfit = currentValue - minimumTillNow;
            maxProfitTillNow = Math.max(currentProfit, maxProfitTillNow);
            minimumTillNow = Math.min(currentValue, minimumTillNow);
        }
        return maxProfitTillNow;
    }

    public static void main(String[] args) {
        int i = new BestTimeToBuyAndSellStocksI().maxProfit(Arrays.asList(2,10, 1, 6, 12, 0));
        System.out.println(i);
    }

}
