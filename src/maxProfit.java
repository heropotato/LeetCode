/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/25/13
 * Time: 9:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class maxProfit {

    /*
    *
    * Best Time to Buy and Sell Stock
    *
    * Say you have an array for which the ith element is the price of a given stock on day i.
    *
    * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
    *
    *
    * */

    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.

        // iterate the array to find out: the Lowest price and the Maximum profit

        if (prices.length<2) return 0;

        int lowestPrice = prices[0];
        int maxProfit = 0;

        for (int i : prices){
            int currentProfit = i - lowestPrice;
            if (currentProfit > maxProfit) maxProfit = currentProfit;
            if (i < lowestPrice) lowestPrice = i;
        }

        return maxProfit;
    }

 }
