/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/20/13
 * Time: 4:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class buildTree {

    /*
    *
    * Construct Binary Tree from Preorder and Inorder Traversal
    *
    *
    * Given preorder and inorder traversal of a tree, construct the binary tree.
    *
    * Note:
    * You may assume that duplicates do not exist in the tree.
    *
    *
    *
    * */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Note: The Solution object is instantiated only once and is reused by each test case.

        // Hints:
        // preOrder traversal: root -> left -> right;
        // inOrder traversal: left -> root -> right.
        if (preorder.length == 0 || preorder.length != inorder.length) return null;
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int startPRE, int endPRE, int[] inorder, int startIN, int endIN) {

        // considering the 1st TreeNode in preorder is the root of all, find out the root in inroder by root.val;
        // then, considering the preorder:
        // the left subtree nodes should be same as inorder in terms of quantities, and (i-startIN) should be quantities of left subtree nodes
        // left node is in the range of [startPRE+1, startPRE+(i-startIN)], right node is in the range of [startPRE+(i-startIN)+1, endPRE].
        // then, considering the inorder:
        // left node is in the range of [startIN, i-1], right node is in the range of [i+1, endIN].
        if (startPRE > endPRE || startIN > endIN) return null;
        int val = preorder[startPRE];
        TreeNode current = new TreeNode(val);
        int i = startIN;
        while (i<= endIN){
            if (inorder[i] == val) break;
            i++;
        }
        current.left = build(preorder, startPRE + 1, startPRE + (i - startIN), inorder, startIN, i - 1);
        current.right = build(preorder, startPRE + (i - startIN) + 1, endPRE, inorder, i + 1, endIN);
        return current;
    }
}
