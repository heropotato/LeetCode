import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/19/13
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class inorderTraversal {

    /*
    *
    * Binary Tree Inorder Traversal
    *
    * Given a binary tree, return the inorder traversal of its nodes' values.
    *
    * For example:
    * Given binary tree {1,#,2,3},
    *    1
    *     \
    *      2
    *     /
    *    3
    * return [1,3,2].
    *
    * Note: Recursive solution is trivial, could you do it iteratively?
    *
    * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
    *
    * OJ's Binary Tree Serialization:
    * The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
    *
    * Here's an example:
    *     1
    *    / \
    *   2   3
    *      /
    *     4
    *      \
    *      5
    *
    * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
    *
    *
    *
    * */

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        inorderTraversal(root, res);
        return res;
    }

    public void inorderTraversal(TreeNode root, ArrayList<Integer> res){
        if(root==null) return;
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }


 }
