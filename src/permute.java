import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/4/13
 * Time: 2:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class permute {

    /*
    *
    * Permutations
    *
    * Given a collection of numbers, return all possible permutations.
    *
    * For example,
    * [1,2,3] have the following permutations:
    * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
    *
    *
    *
    * */

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num.length == 0) return res;

        for (int n : num) {
            ArrayList<ArrayList<Integer>> newRes = new ArrayList<ArrayList<Integer>>();
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
                    newRes.add(temp);
                    i++;
                }
            }
            res = newRes;
        }
        return res;
    }
}
