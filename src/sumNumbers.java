import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/27/13
 * Time: 8:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class sumNumbers {

    /*
    *
    * Sum Root to Leaf Numbers
    *
    * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
    *
    * An example is the root-to-leaf path 1->2->3 which represents the number 123.
    *
    * Find the total sum of all root-to-leaf numbers.
    *
    * For example,
    *
    *       1
    *      / \
    *     2   3
    *
    * The root-to-leaf path 1->2 represents the number 12.
    * The root-to-leaf path 1->3 represents the number 13.
    *
    * Return the sum = 12 + 13 = 25.
    *
    *
    * */

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int res){

        if(root == null) return 0;
        res = res*10 + root.val;

        int sum=0;
        sum+=sumNumbers(root.left, res);
        sum+=sumNumbers(root.right, res);
        return sum==0?res:sum; //if current node has neither left nor right child, return res
    }

}
