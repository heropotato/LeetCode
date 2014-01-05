import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/1/13
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class combinationSum {

    /*
    *
    * Combination Sum
    *
    * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
    *
    * The same repeated number may be chosen from C unlimited number of times.
    *
    * Note:
    * All numbers (including target) will be positive integers.
    * Elements in a combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 ? a2 ? � ? ak).
    * The solution set must not contain duplicate combinations.
    *
    * For example, given candidate set 2,3,6,7 and target 7,
    * A solution set is:
    * [7]
    * [2, 2, 3]
    *
    * */

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // A back-trace solution
        //
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, new ArrayList<Integer>(), res, 0);
        return res;
    }

    private void combinationSum(int[] candidates, int target, ArrayList<Integer> solution, ArrayList<ArrayList<Integer>> res, int pos) {
        if (target == 0) {
            ArrayList<Integer> completeSolution = new ArrayList<Integer>(solution);
            if (!res.contains(completeSolution)) res.add(completeSolution);
            return;
        }

        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                solution.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], solution, res, i);
                solution.remove(solution.size() - 1);
            }
        }
    }

}
