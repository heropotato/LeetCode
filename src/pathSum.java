import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/25/13
 * Time: 3:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class pathSum {

    /*
    *
    * Path Sum II
    *
    * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
    *
    * For example:
    * Given the below binary tree and sum = 22,
    *
    *
    *           5
    *          / \
    *         4   8
    *        /   / \
    *       11  13  4
    *      /  \    / \
    *     7    2  5   1
    *
    *
    * return
    *
    * [
    *   [5,4,11,2],
    *   [5,8,4,5]
    * ]
    *
    *
    * */

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) return res;

        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> sumStack = new Stack<Integer>();
        Stack<ArrayList<Integer>> pathStack = new Stack<ArrayList<Integer>>();
        nodeStack.push(root);
        sumStack.push(root.val);
        ArrayList<Integer> init = new ArrayList<Integer>();
        init.add(root.val);
        pathStack.push(init);

        while (!nodeStack.isEmpty()){
            TreeNode currentNode = nodeStack.pop();
            Integer currentSum = sumStack.pop();
            ArrayList<Integer> currentPath = pathStack.pop();
            if (currentNode.left == null && currentNode.right == null && currentSum == sum){
                ArrayList<Integer> curPath = new ArrayList<Integer>(currentPath);
                res.add(curPath);
            }

            if (currentNode.right != null){
                nodeStack.push(currentNode.right);
                sumStack.push(currentSum+currentNode.right.val);
                ArrayList<Integer> curPath = new ArrayList<Integer>(currentPath);
                curPath.add(currentNode.right.val);
                pathStack.push(curPath);
            }

            if (currentNode.left != null){
                nodeStack.push(currentNode.left);
                sumStack.push(currentSum+currentNode.left.val);
                ArrayList<Integer> curPath = new ArrayList<Integer>(currentPath);
                curPath.add(currentNode.left.val);
                pathStack.push(curPath);
            }
        }

        return res;

    }
 }
