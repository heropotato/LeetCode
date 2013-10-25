/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/25/13
 * Time: 3:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class flatten {

    /*
    *
    * Flatten Binary Tree to Linked List
    *
    * Given a binary tree, flatten it to a linked list in-place.
    *
    *
    * For example,
    * Given
    *
    *       1
    *      / \
    *     2   5
    *    / \   \
    *   3   4   6
    *
    *
    * The flattened tree should look like:
    *
    *   1
    *    \
    *     2
    *      \
    *       3
    *        \
    *         4
    *          \
    *           5
    *            \
    *             6
    *
    *
    * Hints:
    *
    * If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
    *
    *
    * */

    public void flatten(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.

        // recursion solution:
        // (One helper function finding the right furthest node of current node)
        // considering the question, target is flat all left subtrees to right
        // if current node has no left sub node, then simply flatten the right sub node
        // otherwise,
        // find the furthest right node (furNode) of the left sub tree,
        // merge the left sub tree to replace the current right sub node
        // and attach the original right sub node to the furNode
        // flatten the right sub node

        if (root == null || (root.left == null && root.right == null)) return;
        if (root.left != null) {
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode furthestRight = reachFurthestRight(root.right);
            furthestRight.right = tmp;
            flatten(root.right);
        } else if (root.right != null) {
            flatten(root.right);
        }
    }

    public TreeNode reachFurthestRight(TreeNode root) {
        if (root.right != null) return reachFurthestRight(root.right);
        else return root;
    }
}
