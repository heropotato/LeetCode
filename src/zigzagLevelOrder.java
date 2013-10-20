import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/20/13
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class zigzagLevelOrder {

    /*
    *
    * Binary Tree Zigzag Level Order Traversal
    *
    * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
    *
    *
    * For example:
    * Given binary tree {3,9,20,#,#,15,7},
    *           3
    *          / \
    *         9  20
    *           /  \
    *         15   7
    *
    *
    * return its zigzag level order traversal as:
    *
    *
    *
    * [
    *   [3],
    *   [20,9],
    *   [15,7]
    * ]
    *
    *
    *
    * */

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) return res;
        LinkedBlockingQueue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
        LinkedBlockingQueue<TreeNode> nextQueue = new LinkedBlockingQueue<TreeNode>();
        TreeNode current = root;
        ArrayList<Integer> level = new ArrayList<Integer>();
        Boolean flipFlag = false;

        while (current!=null){
            level.add(current.val);
            if(current.left!=null) nextQueue.offer(current.left);
            if(current.right!=null) nextQueue.offer(current.right);

            if (queue.isEmpty()){
                queue = nextQueue;
                nextQueue = new LinkedBlockingQueue<TreeNode>();
                if(flipFlag) Collections.reverse(level);
                res.add(level);
                level = new ArrayList<Integer>();
                flipFlag = !flipFlag;
            }
            current = queue.poll();
        }

        return res;
    }
 }
