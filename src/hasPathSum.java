import java.util.Stack;

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

        if (root == null) return false;

        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> currentSumStack = new Stack<Integer>();
        nodeStack.add(root);
        currentSumStack.add(root.val);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            Integer currentSum = currentSumStack.pop();
            if (node.left == null && node.right == null && currentSum == sum) return true;

            if (node.right != null) {
                nodeStack.add(node.right);
                currentSumStack.add(currentSum + node.right.val);
            }

            if (node.left != null) {
                nodeStack.add(node.left);
                currentSumStack.add(currentSum + node.left.val);
            }
        }
        return false;
    }

}
