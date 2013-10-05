import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/4/13
 * Time: 3:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class permuteUnique {

    /*
    *
    * Permutations II
    *
    * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
    *
    * For example,
    * [1,1,2] have the following unique permutations:
    * [1,1,2], [1,2,1], and [2,1,1].
    *
    *
    * */

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num.length == 0) return res;

        for (int n : num) {
            ArrayList<ArrayList<Integer>> newRes = new ArrayList<ArrayList<Integer>>();
            HashSet<ArrayList<Integer>> noDuplicates = new HashSet<ArrayList<Integer>>();
            if (res.size() == 0) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(n);
                res.add(temp);
                continue;
            }
            for (ArrayList<Integer> tempList : res) {
                int i = 0;
                while (i <= tempList.size()) {
                    ArrayList<Integer> temp = new ArrayList<Integer>(tempList);
                    temp.add(i, n);
                    if(noDuplicates.add(temp)) newRes.add(temp);
                    i++;
                }
            }
            res = newRes;
        }
        return res;
    }
}
