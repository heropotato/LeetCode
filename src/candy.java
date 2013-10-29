import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/28/13
 * Time: 7:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class candy {

    /*
    *
    * Candy
    *
    *
    * There are N children standing in a line. Each child is assigned a rating value.
    *
    * You are giving candies to these children subjected to the following requirements:
    *
    * Each child must have at least one candy.
    * Children with a higher rating get more candies than their neighbors.
    * What is the minimum candies you must give?
    *
    * */

    public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (ratings.length ==0) return 0;
        int res = 0, prev = ratings[0];
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 0; i < ratings.length; i++){
            if (ratings[i] > prev && candies[i] <= candies[i-1]){
                candies[i] += candies[i-1];
            }
            prev = ratings[i];
        }
        prev = ratings[ratings.length-1];
        for (int i = ratings.length-1; i>=0; i--){
            if (ratings[i] > prev && candies[i] < candies[i+1]+1){
                candies[i] = candies[i+1]+1;
            }
            prev = ratings[i];
            res+=candies[i];
        }
        return res;
    }
 }
