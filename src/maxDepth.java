/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/20/13
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class maxDepth {

    /*
    *
    * Maximum Depth of Binary Tree
    *
    *
    * Given a binary tree, find its maximum depth.
    *
    * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    *
    *
    *
    * */

    public int maxDepth(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
    }

 }
