/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/21/13
 * Time: 6:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class buildTreeII {

    /*
    *
    * Construct Binary Tree from Inorder and Postorder Traversal
    *
    *
    * Given inorder and postorder traversal of a tree, construct the binary tree.
    *
    * Note:
    * You may assume that duplicates do not exist in the tree.
    *
    *
    * */

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (inorder.length == 0 || inorder.length != postorder.length) return null;
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int startIN, int endIN, int[] postorder, int startPOST, int endPOST) {
        if (startIN > endIN || startPOST > endPOST) return null;
        int val = postorder[endPOST];
        TreeNode current = new TreeNode(val);
        int i = startIN;
        while (i <= endIN) {
            if (inorder[i] == val) break;
            i++;
        }
        current.right = buildTree(inorder, i + 1, endIN, postorder, endPOST - endIN + i, endPOST - 1);
        current.left = buildTree(inorder, startIN, i - 1, postorder, startPOST, endPOST - endIN + i - 1);

        return current;
    }
}
