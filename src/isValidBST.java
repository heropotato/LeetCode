/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/20/13
 * Time: 1:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class isValidBST {

    /*
    *
    * Validate Binary Search Tree
    *
    * Given a binary tree, determine if it is a valid binary search tree (BST).
    *
    * Assume a BST is defined as follows:
    *
    * The left subtree of a node contains only nodes with keys less than the node's key.
    * The right subtree of a node contains only nodes with keys greater than the node's key.
    * Both the left and right subtrees must also be binary search trees.
    * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
    *
    *
    * OJ's Binary Tree Serialization:
    * The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
    *
    *
    * Here's an example:
    *
    *       1
    *      / \
    *     2   3
    *        /
    *       4
    *        \
    *         5
    *
    * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
    *
    *
    * */

    public boolean isValidBST(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return root == null ? true : isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer bottom, Integer top) {
        if (root == null) {
            return true;
        } else if (bottom != null && root.val <= bottom) {
            return false;
        } else if (top != null && root.val >= top) {
            return false;
        } else {
            return isValidBST(root.left, bottom, root.val) && isValidBST(root.right, root.val, top);
        }
    }
}