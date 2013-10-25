/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/25/13
 * Time: 12:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class isBalanced {

    /*
    *
    * Balanced Binary Tree
    *
    * Given a binary tree, determine if it is height-balanced.
    *
    * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
    *
    *
    *
    *
    * */

    public boolean isBalanced(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(root == null) return true;

        int leftDepth = getDepth(root.left), rightDepth = getDepth(root.right);
        if(Math.abs(leftDepth-rightDepth)>1) return false;
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    public int getDepth(TreeNode root){
        if(root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right))+1;
    }

}
