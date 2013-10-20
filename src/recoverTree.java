import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/20/13
 * Time: 1:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class recoverTree {

    /*
    *
    * Recover Binary Search Tree
    *
    * Two elements of a binary search tree (BST) are swapped by mistake.
    *
    *
    * Recover the tree without changing its structure.
    *
    *
    * Note:
    * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
    *
    *
    * */

    public void recoverTree(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.

        // in-order traverse the BST, and store node accordingly in an ArrayList
        // locate two wrong positioned elements, swap
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        inOrderTraverse(root, nodes);
        int i = 0, j = nodes.size()-1;
        while (nodes.get(i).val < nodes.get(i + 1).val){
            i++;
        }
        while (nodes.get(j).val > nodes.get(j - 1).val){
            j--;
        }
        int temp = nodes.get(i).val;
        nodes.get(i).val = nodes.get(j).val;
        nodes.get(j).val = temp;
        return;
    }

    private void inOrderTraverse(TreeNode node, ArrayList<TreeNode> nodes) {
        if (node == null) return;
        inOrderTraverse(node.left, nodes);
        nodes.add(node);
        inOrderTraverse(node.right, nodes);
    }
}
