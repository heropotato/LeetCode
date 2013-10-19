/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/19/13
 * Time: 2:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class numTrees {

    /*
    *
    * Unique Binary Search Trees
    *
    * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
    *
    * For example,
    *
    * Given n = 3, there are a total of 5 unique BST's.
    *
    *
    *   1         3     3      2      1
    *    \       /     /      / \      \
    *     3     2     1      1   3      2
    *    /     /       \                 \
    *   2     1         2                 3
    *
    *
    * */

/*
     // a really neat solution via http://discuss.leetcode.com/questions/270/unique-binary-search-trees
     public int numTrees(int n) {
        int c = 1;
        for (int i = 2; i <= n; i++)
            c = 2*(2*i-1)*c/(i+1);
        return c;
    }
*/

    // inspired from http://yucoding.blogspot.com/2013/04/leetcode-question-114-unique-binary.html
    // recursively count the number of left sub tree times number of right sub tree.
    public int numTrees(int n) {

        if (n==0 || n == 1) return 1;
        int sum=0;
        for (int i=1;i<=n;i++){
            sum += numTrees(i-1)*numTrees(n-i);
        }
        return sum;
    }

}
