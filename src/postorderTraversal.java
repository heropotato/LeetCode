import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 11/7/13
 * Time: 10:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class postorderTraversal {

    /*
    *
    * Binary Tree Postorder Traversal
    *
    * Given a binary tree, return the postorder traversal of its nodes' values.
    *
    *
    * For example:
    *
    * Given binary tree {1,#,2,3},
    *
    * 1
    *  \
    *   2
    *  /
    * 3
    *
    * return [3,2,1].
    *
    * Note: Recursive solution is trivial, could you do it iteratively?
    *
    * */

    // recursive solution
    /*
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> res = new ArrayList<Integer>();
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(TreeNode root, ArrayList<Integer> res){
        if (root == null) return;
        postorderTraversal(root.left, res);
        postorderTraversal(root.right, res);
        res.add(root.val);
    }

    */

    // iterative solution
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // DFS based solution
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        if (root != null) nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            root = nodeStack.pop();
            res.add(root.val);
            if (root.left != null)  nodeStack.push(root.left);
            if (root.right != null) nodeStack.push(root.right);
        }
        Collections.reverse(res);
        return res;
    }
}
