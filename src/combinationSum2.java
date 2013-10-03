import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/2/13
 * Time: 8:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class combinationSum2 {

    /*
    *
    * Combination Sum II
    *
    * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
    *
    * Each number in C may only be used once in the combination.
    *
    * Note:
    * All numbers (including target) will be positive integers.
    * Elements in a combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 ? a2 ? � ? ak).
    * The solution set must not contain duplicate combinations.
    *
    * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
    * A solution set is:
    * [1, 7]
    * [1, 2, 5]
    * [2, 6]
    *
    *
    *
    * */

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        if (num.length == 0 || target < num[0]) return res;
        combinationSum2(num, target, 0, new ArrayList<Integer>(), res);
        return res;
    }

    public void combinationSum2(int[] num, int target, int startIndex, ArrayList<Integer> combination, ArrayList<ArrayList<Integer>> res) {
        if (target == 0) {
            ArrayList<Integer> current = new ArrayList<Integer>(combination);
            if (!res.contains(current)) res.add(current);
            return;
        }

        for (int i = startIndex; i < num.length; i++) {
            if (num[i] > target) return;
            combination.add(num[i]);
            combinationSum2(num, target - num[i], i + 1, combination, res);
            combination.remove(combination.size() - 1);
        }
    }
}
