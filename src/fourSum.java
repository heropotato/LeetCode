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
        int pointer = 0;

        while (pointer <= num.length - 4) {
            int tempTarget = target - num[pointer];
            int[] tempNum = Arrays.copyOfRange(num, pointer + 1, num.length);

            for (ArrayList<Integer> list : threeSum(tempNum, tempTarget, num[pointer])) {
                if (hashSet.add(list)) res.add(list);
            }
            pointer++;
        }

        return res;
    }

    private ArrayList<ArrayList<Integer>> threeSum(int[] num, int target, int pre) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num.length < 3) return res;

        for (int i = 0; i < num.length - 2; i++) {
            int lPointer = i + 1;
            int rPointer = num.length - 1;

            while (lPointer < rPointer) {
                if (num[i] + num[lPointer] + num[rPointer] > target) {
                    rPointer--;
                } else if (num[i] + num[lPointer] + num[rPointer] < target) {
                    lPointer++;
                } else {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(pre);
                    temp.add(num[i]);
                    temp.add(num[lPointer]);
                    temp.add(num[rPointer]);

                    res.add(temp);
                    rPointer--;
                    lPointer++;
                }
            }

        }

        return res;
    }
}
