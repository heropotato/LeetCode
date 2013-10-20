/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/20/13
 * Time: 1:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class isSameTree {

    /*
    *
    * Same Tree
    *
    * Given two binary trees, write a function to check if they are equal or not.
    *
    *
    * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
    *
    *
    * */

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (p == null) return q == null;
        if (q == null) return p == null;

        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
 }
