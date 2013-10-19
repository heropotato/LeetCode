import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/19/13
 * Time: 12:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class subsetsWithDup {

    /*
    *
    * Subsets II
    *
    * Given a collection of integers that might contain duplicates, S, return all possible subsets.
    *
    * Note:
    * Elements in a subset must be in non-descending order.
    * The solution set must not contain duplicate subsets.
    * For example,
    * If S = [1,2,2], a solution is:
    *
    * [
    *   [2],
    *   [1],
    *   [1,2,2],
    *   [2,2],
    *   [1,2],
    *   []
    * ]
    *
    *
    * */

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.

        // quite same as "subsets" question, use HashSet<ArrayList<Integer>> to avoid adding duplicate combinations
        if (num.length == 0) return null;
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        HashSet<ArrayList<Integer>> noDup = new HashSet<ArrayList<Integer>>();
        int i = 0;
        while (i <= num.length) {
            subsets(num, 0, i, new ArrayList<Integer>(), res, noDup);
            i++;
        }
        return res;
    }

    public void subsets(int[] S, int startIndex, int length, ArrayList<Integer> currentCombination, ArrayList<ArrayList<Integer>> res, HashSet<ArrayList<Integer>> noDup) {

        if (currentCombination.size() == length) {
            ArrayList<Integer> temp = new ArrayList<Integer>(currentCombination);
            if(noDup.add(temp)) res.add(temp);
        }

        for (int i = startIndex; i < S.length; i++) {
            currentCombination.add(S[i]);
            subsets(S, i + 1, length, currentCombination, res, noDup);
            currentCombination.remove(currentCombination.size() - 1);
        }

    }

 }
