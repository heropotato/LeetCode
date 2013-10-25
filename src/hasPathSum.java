/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/25/13
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class hasPathSum {

    /*
    *
    * Path Sum
    *
    * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
    *
    * For example:
    * Given the below binary tree and sum = 22,
    *           5
    *          / \
    *         4   8
    *        /   / \
    *      11  13  4
    *     /  \      \
    *    7    2      1
    *
    * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
    *
    *
    * */

    public boolean hasPathSum(TreeNode root, int sum) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (root==null) return false;
        if (root.left ==null&&root.right==null){
            return root.val == sum;
        }else if (root.left == null){
            return hasPathSum(root.right, sum, root.val);
        }else if (root.right == null){
            return hasPathSum(root.left, sum, root.val);
        }else {
            return hasPathSum(root.left, sum, root.val) || hasPathSum(root.right, sum, root.val);
        }
    }

    public boolean hasPathSum(TreeNode root, int sum, int currentSum){
        if (root == null) return currentSum==sum;
        currentSum += root.val;
        if (currentSum>sum) return false;
        if (root.left == null && root.right == null) return currentSum == sum;
        return hasPathSum(root.left, sum, currentSum) || hasPathSum(root.right, sum, currentSum);
    }

 }
