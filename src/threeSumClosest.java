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

        Arrays.sort(num);
        int res = num[0] + num[1] + num[2];

        for (int i = 0; i < num.length - 2; i++) {

            int lPointer = i + 1;
            int rPointer = num.length - 1;

            while (lPointer < rPointer) {

                int temp = num[i] + num[lPointer] + num[rPointer];
                if (temp == target) {
                    return target;
                } else if (temp > target) {
                    if (Math.abs(target - res) > Math.abs(target - temp)) res = temp;
                    rPointer--;
                } else {
                    if (Math.abs(target - res) > Math.abs(target - temp)) res = temp;
                    lPointer++;
                }
            }

        }
        return res;
    }

}
