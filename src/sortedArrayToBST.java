import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/21/13
 * Time: 7:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class sortedArrayToBST {

    /*
    *
    * Convert Sorted Array to Binary Search Tree
    *
    *
    * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
    *
    *
    *
    * */

    public TreeNode sortedArrayToBST(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (num.length < 1) return null;

        Integer edge = new Integer(num.length/2);
        TreeNode root = new TreeNode(num[edge]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(num, 0, edge));
        root.right = sortedArrayToBST(Arrays.copyOfRange(num, edge + 1, num.length));
        return root;
    }
}
