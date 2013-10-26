import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/26/13
 * Time: 12:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class maxPathSum {

    /*
    *
    * Binary Tree Maximum Path Sum
    *
    * Given a binary tree, find the maximum path sum.
    *
    * The path may start and end at any node in the tree.
    *
    * For example:
    *
    * Given the below binary tree,
    *
    *       1
    *      / \
    *     2   3
    *
    * Return 6.
    *
    *
    *
    * */

    public int maxPathSum(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // get inspired from http://discuss.leetcode.com/questions/288/binary-tree-maximum-path-sum/356

        Stack<Integer> maxSums = new Stack<Integer>();
        maxSums.push(Integer.MIN_VALUE);
        maxPathSum(root, maxSums);
        return maxSums.pop();
    }

    private int maxPathSum(TreeNode root, Stack<Integer> maxSums) {
        if (root == null) return 0;
        int leftMax = Math.max(0, maxPathSum(root.left, maxSums));
        int rightMax = Math.max(0, maxPathSum(root.right, maxSums));
        maxSums.push(Math.max(maxSums.peek(), root.val + leftMax + rightMax));
        return Math.max(root.val + leftMax, root.val + rightMax);
    }

/*
    One needs to handle three cases:

    Left tree path plus the current root.
    Right tree path plus the current root.
    The path passes through the root and hence one needs to consider the left path + current root + right path.
    In addition compare with the max path so far and update accordingly.

 */


/*

    int maxPathSum(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int csum;
        int maxsum = INT_MIN;
        maxPathSumHelper(root, csum, maxsum);
        return maxsum;

    }
    void maxPathSumHelper(TreeNode *node, int &csum, int &maxsum) {
        if (!node) {
            csum = 0;
            return;
        }
        int lsum = 0, rsum = 0;
        maxPathSumHelper(node->left, lsum, maxsum);
        maxPathSumHelper(node->right, rsum, maxsum);
        csum = max(node->val, max(node->val + lsum, node->val + rsum));
        maxsum = max(maxsum, max(csum, node->val + lsum + rsum));
    }

    */
}
