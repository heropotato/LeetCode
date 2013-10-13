import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/13/13
 * Time: 1:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class subsets {

    /*
    *
    * Subsets
    *
    * Given a set of distinct integers, S, return all possible subsets.
    *
    * Note:
    * Elements in a subset must be in non-descending order.
    * The solution set must not contain duplicate subsets.
    * For example,
    * If S = [1,2,3], a solution is:
    *
    * [
    *   [3],
    *   [1],
    *   [2],
    *   [1,2,3],
    *   [1,3],
    *   [2,3],
    *   [1,2],
    *   []
    * ]
    *
    *
    * */

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Note: The Solution object is instantiated only once and is reused by each test case.

        if (S.length == 0) return null;
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int i = 0;
        while (i <= S.length) {
            subsets(S, 0, i, new ArrayList<Integer>(), res);
            i++;
        }
        return res;
    }

    public void subsets(int[] S, int startIndex, int length, ArrayList<Integer> currentCombination, ArrayList<ArrayList<Integer>> res) {

        if (currentCombination.size() == length) {
            ArrayList<Integer> temp = new ArrayList<Integer>(currentCombination);
            res.add(temp);
        }

        for (int i = startIndex; i < S.length; i++) {
            currentCombination.add(S[i]);
            subsets(S, i + 1, length, currentCombination, res);
            currentCombination.remove(currentCombination.size() - 1);
        }

    }

}
