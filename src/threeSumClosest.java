import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/23/13
 * Time: 12:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class threeSumClosest {

    /*
    *
    * 3Sum Closest
    *
    * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
    *
    * Return the sum of the three integers. You may assume that each input would have exactly one solution.
    *
    * For example, given array S = {-1 2 1 -4}, and target = 1.
    *
    * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    *
    *
    * */

    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // A similar question to 3Sum, use three pointers to find closest 3Sum
        Arrays.sort(num);
        int res = num[0] + num[1] + num[2];

        for (int i = 0; i < num.length - 2; i++) {
            int leftP = i + 1;
            int rightP = num.length - 1;

            while (leftP < rightP) {
                int curSum = num[i] + num[leftP] + num[rightP];
                if (curSum == target) return target;
                else {
                    if (Math.abs(target - curSum) < Math.abs(target - res)) res = curSum;
                    if (curSum > target) rightP--;
                    else leftP++;
                }
            }
        }
        return res;
    }
}
