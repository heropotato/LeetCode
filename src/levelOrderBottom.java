import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/21/13
 * Time: 7:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class levelOrderBottom {

    /*
    *
    * Binary Tree Level Order Traversal II
    *
    * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
    *
    * For example:
    * Given binary tree {3,9,20,#,#,15,7},
    *
    *           3
    *          / \
    *         9  20
    *           /  \
    *          15   7
    *
    * return its bottom-up level order traversal as:
    *
    * [
    *   [15,7]
    *   [9,20],
    *   [3],
    * ]
    *
    *
    * */

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) return res;

        LinkedBlockingQueue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
        LinkedBlockingQueue<TreeNode> nextQueue = new LinkedBlockingQueue<TreeNode>();
        ArrayList<Integer> currentLevel = new ArrayList<Integer>();
        TreeNode current = root;

        while (current != null) {
            currentLevel.add(current.val);
            if (current.left != null) nextQueue.offer(current.left);
            if (current.right != null) nextQueue.offer(current.right);

            if (queue.isEmpty()) {
                queue = nextQueue;
                nextQueue = new LinkedBlockingQueue<TreeNode>();
                res.add(currentLevel);
                currentLevel = new ArrayList<Integer>();
            }
            current = queue.poll();
        }

        if (res.size() != 0) {
            int i = 0;
            int j = res.size() - 1;
            while (i < j) {
                ArrayList<Integer> temp = new ArrayList<Integer>(res.get(i));
                res.set(i, res.get(j));
                res.set(j, temp);
                i++;
                j--;
            }
        }
        return res;
    }

}
