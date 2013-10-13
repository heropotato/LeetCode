/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/9/13
 * Time: 2:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class getPermutation {

    /*
    *
    * Permutation Sequence
    *
    * The set [1,2,3,…,n] contains a total of n! unique permutations.
    *
    * By listing and labeling all of the permutations in order,
    * We get the following sequence (ie, for n = 3):
    *
    * "123"
    * "132"
    * "213"
    * "231"
    * "312"
    * "321"
    *
    *
    * Given n and k, return the kth permutation sequence.
    *
    * Note: Given n will be between 1 and 9 inclusive.
    *
    *
    * Hints:
    *
    * Inspired from Yu's Coding Garden: http://yucoding.blogspot.com/2013/04/leetcode-question-68-permutation.html
    *
    * */

    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = i + 1;
        }
        k = k - 1;
        StringBuffer res = new StringBuffer("");

        for (int i = n - 1; i >= 0; i--) {
            int times = k / factOfN(i);
            for (int sc = 0; sc <= times; sc++) {
                if (temp[sc] == -1) times++;
            }
            res.append(temp[times]);
            temp[times] = -1;
            k = k % factOfN(i);
        }
        return res.toString();

    }

    private int factOfN(int n) {
        if (n == 0) return 1;
        return n * factOfN(n - 1);
    }
}
