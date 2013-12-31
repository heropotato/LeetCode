import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/23/13
 * Time: 10:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class threeSum {

    /*
    *
    * 3Sum
    *
    * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
    *
    * */

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // A three pointer solution
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num.length < 3) return res;
        Arrays.sort(num);
        HashSet hashSet = new HashSet();

        for (int i = 0; i < num.length - 2; i++) {
            int leftP = i + 1;
            int rightP = num.length - 1;

            while (leftP < rightP) {
                if (num[i] + num[leftP] + num[rightP] > 0) rightP--;
                else if (num[i] + num[leftP] + num[rightP] < 0) leftP++;
                else {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(num[i]);
                    temp.add(num[leftP]);
                    temp.add(num[rightP]);
                    if (hashSet.add(temp)) res.add(temp);
                    rightP--;
                    leftP++;
                }
            }
        }
        return res;
    }
}
