import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/19/13
 * Time: 7:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class generateTrees {

    /*
    *
    * Unique Binary Search Trees II
    *
    * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
    *
    * For example,
    * Given n = 3, your program should return all 5 unique BST's shown below.
    *
    *  1         3     3      2      1
    *   \       /     /      / \      \
    *    3     2     1      1   3      2
    *   /     /       \                 \
    *  2     1         2                 3
    *
    *
    *
    *  OJ's Binary Tree Serialization:
    *
    *  The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
    *
    *  Here's an example:
    *      1
    *     / \
    *    2   3
    *       /
    *      4
    *       \
    *        5
    *
    *
    * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
    *
    *
    * */

    public ArrayList<TreeNode> generateTrees(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return generateTrees(1, n);
    }

    private ArrayList<TreeNode> generateTrees(int start, int end) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            for (TreeNode left : generateTrees(start, i - 1)) {
                for (TreeNode right : generateTrees(i + 1, end)) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

}
