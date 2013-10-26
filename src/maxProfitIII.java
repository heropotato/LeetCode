import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/25/13
 * Time: 9:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class maxProfitIII {

    /*
    *
    * Best Time to Buy and Sell Stock III
    *
    * Say you have an array for which the ith element is the price of a given stock on day i.
    *
    *
    * Design an algorithm to find the maximum profit. You may complete at most two transactions.
    *
    * Note:
    * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    *
    *
    * */

    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.

        if (prices.length<2) return 0;

        ArrayList<Integer> maxProfits = new ArrayList<Integer>();

        int lowestPrice = prices[0], maxProfit = 0;

        for (int price: prices){
            int profit = price - lowestPrice;
            if (profit > maxProfit) maxProfit = profit;
            if (price < lowestPrice) lowestPrice = price;
            maxProfits.add(maxProfit);
        }

        int highestPrice = prices[prices.length-1], finalRes = maxProfits.get(maxProfits.size()-1);
        maxProfit = 0;

        for (int i = maxProfits.size()-1; i>=0; i--){
            int profit = highestPrice - prices[i];
            if (profit > maxProfit) maxProfit = profit;
            int finalProfit = maxProfit + maxProfits.get(i);
            if (finalProfit > finalRes) finalRes = finalProfit;
            if (prices[i] > highestPrice) highestPrice = prices[i];
        }

        return finalRes;

    }
 }
