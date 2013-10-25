/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/25/13
 * Time: 1:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class minDepth {

    /*
    *
    * Minimum Depth of Binary Tree
    *
    * Given a binary tree, find its minimum depth.
    *
    * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
    *
    *
    * */


    public int minDepth(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) {
            return 1 + minDepth(root.right);
        } else if (root.right == null) {
            return 1 + minDepth(root.left);
        } else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }
}
