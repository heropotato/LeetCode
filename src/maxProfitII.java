/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/25/13
 * Time: 9:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class maxProfitII {

    /*
    *
    * Best Time to Buy and Sell Stock II
    *
    * Say you have an array for which the ith element is the price of a given stock on day i.
    *
    * Design an algorithm to find the maximum profit.
    *
    * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    *
    *
    * */

    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.

        // iterate the array, accumulate all price differences which matching the condition prices[i] - prices[i-1] > 0;
        if (prices.length < 2) return 0;
        int maxProfit = 0;
        int prev = prices[0];

        for (int i : prices) {
            if (i - prev > 0) maxProfit += i - prev;
            prev = i;
        }

        return maxProfit;

    }
}
