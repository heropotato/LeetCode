import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 11/6/13
 * Time: 11:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class preorderTraversal {

    /*
    *
    *
    * Binary Tree Preorder Traversal
    *
    * Given a binary tree, return the preorder traversal of its nodes' values.
    *
    * For example:
    * Given binary tree {1,#,2,3},
    *    1
    *    \
    *    2
    *   /
    *  3
    *
    *
    * return [1,2,3].
    *
    * Note: Recursive solution is trivial, could you do it iteratively?
    *
    *
    *
    * */


    /*
    // recursive solution

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        ArrayList<Integer> res = new ArrayList<Integer>();
        preorderTraversal(root, res);
        return res;
    }

    private void preorderTraversal(TreeNode root, ArrayList<Integer> res){
        if (root== null) return;
        res.add(root.val);
        preorderTraversal(root.left, res);
        preorderTraversal(root.right, res);
    }*/

    //iterative solution

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        ArrayList<Integer> res = new ArrayList<Integer>();
        //DFS based solution
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        if (root!=null)nodeStack.push(root);
        while (!nodeStack.isEmpty()){
            root = nodeStack.pop();
            res.add(root.val);
            if (root.right!=null) nodeStack.push(root.right);
            if (root.left!=null) nodeStack.push(root.left);
        }
        return res;
    }

}
