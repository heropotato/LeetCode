/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/20/13
 * Time: 2:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class isSymmetric {

    /*
    *
    * Symmetric Tree
    *
    * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
    *
    * For example, this binary tree is symmetric:
    *
    *           1
    *          / \
    *         2   2
    *        / \ / \
    *       3  4 4  3
    *
    * But the following is not:
    *
    *           1
    *          / \
    *         2   2
    *          \   \
    *          3    3
    *
    * Note:
    * Bonus points if you could solve it both recursively and iteratively.
    *
    *
    *
    * */

    public boolean isSymmetric(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode origin, TreeNode mirror) {
        if (origin == null) return mirror == null;
        if (mirror == null) return origin == null;

        if(origin.val != mirror.val) return false;
        return isSymmetric(origin.left, mirror.right)&&isSymmetric(origin.right, mirror.left);
    }

}
