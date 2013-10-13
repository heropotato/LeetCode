import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/12/13
 * Time: 11:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class combine {

    /*
    *
    * Combinations
    *
    * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
    *
    * For example,
    * If n = 4 and k = 2, a solution is:
    * [
    *   [2,4],
    *   [3,4],
    *   [2,3],
    *   [1,2],
    *   [1,3],
    *   [1,4],
    * ]
    *
    *
    * */

    public static void main(String[] args) {
/*
        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        b.add(2);
        b.add(1);
        hashSet.add(new ArrayList<Integer>(a));

        System.out.println("HEY: " + hashSet.add(new ArrayList<Integer>(b)));*/

        ArrayList<Integer> t = new ArrayList<Integer>(8);
        long start = System.currentTimeMillis();
        System.out.println("HEY: " + combine(13, 10));
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));

    }

    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function

        //get inspired form yuanx's GitHub repository: https://github.com/yuanx/leetcode/blob/master/Combinations.java
        //a truly elegant back trace recursion solution

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        generateList(n, k, new ArrayList<Integer>(), res, 0);
        return res;
    }

    private static void generateList(int n, int k, ArrayList<Integer> currentCombination, ArrayList<ArrayList<Integer>> res, int start) {

        //base case: once currentCombination size is matching k, then it is considered as a valid combination, add to result
        if (currentCombination.size() == k) {
            ArrayList<Integer> temp = new ArrayList<Integer>(currentCombination);
            res.add(temp);
            return;
        }

        //back trace
        //add each number from 1 to n to a combination list in ascending order
        for (int i = start; i < n; i++) {
            //add each number from 1 to n to a combination list in ascending order
            currentCombination.add(i + 1);
            //recursively add greater number to current combination list one by one
            //this is truly elegant:
            // 1, it covered every single possibilities;
            // 2, due to the ascending order, each adding cannot create duplicate combinations
            //e.g., (n = 4, k = 2), the first combination is evolving as below:
            //[1] --> [1, 2], [1, 3], [1, 4] --> each length is 2 as well as k, all will be added to result
            generateList(n, k, currentCombination, res, i + 1);
            //if the move is failed (without adding to the result list), it goes back here
            //of course, remove the failed adding.
            currentCombination.remove(currentCombination.size() - 1);
        }

    }

/*
    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (k == 0) return null;

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> original = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(i);
            res.add(temp);
            original.add(i);
        }

        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();

        if(k>1){
            res = new ArrayList<ArrayList<Integer>>();
            for (Integer integer: original){
                for (ArrayList<Integer> arrayList: combine(n, k-1)){
                    ArrayList<Integer> tempList = new ArrayList<Integer>(arrayList);
                    if (tempList.contains(integer)) continue;
                    tempList.add(integer);
                    Collections.sort(tempList);
                    if(hashSet.add(tempList)) res.add(tempList);
                }
            }
        }

        return res;
    }
     */
}
