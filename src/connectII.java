import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/25/13
 * Time: 5:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class connectII {

    /*
    *
    * Populating Next Right Pointers in Each Node II
    *
    * Follow up for problem "Populating Next Right Pointers in Each Node".
    *
    * What if the given tree could be any binary tree? Would your previous solution still work?
    *
    * You may only use constant extra space.
    * For example,
    *
    * Given the following perfect binary tree,
    *
    *       1
    *     /  \
    *    2    3
    *   / \    \
    *  4  5    7
    *
    * After calling your function, the tree should look like:
    *
    *       1 -> NULL
    *     /  \
    *    2 -> 3 -> NULL
    *   / \    \
    *  4->5 -> 7 -> NULL
    *
    * */

    public void connect(TreeLinkNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.

        // Following the previous question "Populating Next Right Pointers in Each Node", the solution still work.
        if (root == null) return;

        LinkedBlockingQueue<TreeLinkNode> queue = new LinkedBlockingQueue<TreeLinkNode>();
        LinkedBlockingQueue<TreeLinkNode> levelQueue = new LinkedBlockingQueue<TreeLinkNode>();

        while (root != null) {
            if (queue.isEmpty()) root.next = null;
            root.next = queue.peek();
            if (root.left != null) levelQueue.offer(root.left);
            if (root.right != null) levelQueue.offer(root.right);
            if (queue.isEmpty()) {
                queue = levelQueue;
                levelQueue = new LinkedBlockingQueue<TreeLinkNode>();
            }
            root = queue.poll();
        }
    }

}
