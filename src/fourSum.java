import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/24/13
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class fourSum {

    /*
    *
    * 4Sum
    *
    * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
    *
    * Find all unique quadruplets in the array which gives the sum of target.
    *
    *
    *
    * */

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num.length < 4) return res;
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
        for (int cur = 0; cur< num.length -3; cur++){
            for (ArrayList<Integer> list : threeSum(Arrays.copyOfRange(num, cur + 1, num.length), target-num[cur], num[cur])) {
                if (hashSet.add(list)) res.add(list);
            }
        }
        return res;
    }

    private ArrayList<ArrayList<Integer>> threeSum(int[] num, int target, int cur) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < num.length - 2; i++) {
            int leftP = i + 1;
            int rightP = num.length - 1;

            while (leftP < rightP) {
                if (num[i] + num[leftP] + num[rightP] > target) rightP--;
                else if (num[i] + num[leftP] + num[rightP] < target) leftP++;
                else {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(cur);
                    temp.add(num[i]);
                    temp.add(num[leftP]);
                    temp.add(num[rightP]);

                    res.add(temp);
                    rightP--;
                    leftP++;
                }
            }
        }
        return res;
    }
}
