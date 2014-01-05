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

        // Simiplar to the solution of "combinationSum"
        // Only difference is that when doing "try", each position on num[] count only once
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        combinationSum2(num, target, new ArrayList<Integer>(), res, 0);
        return res;
    }

    private void combinationSum2(int[] num, int target, ArrayList<Integer> solution, ArrayList<ArrayList<Integer>> res, int pos){
        if (target == 0){
            ArrayList<Integer> completeSolution = new ArrayList<Integer>(solution);
            if (!res.contains(completeSolution)) res.add(completeSolution);
            return;
        }

        for (int i = pos; i<num.length; i++){
            if (num[i] <=target){
                solution.add(num[i]);
                combinationSum2(num, target-num[i], solution, res, i+1);
                solution.remove(solution.size()-1);
            }
        }
    }
}
