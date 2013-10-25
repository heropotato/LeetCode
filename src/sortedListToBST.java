import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/21/13
 * Time: 7:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class sortedListToBST {

    /*
    *
    * Convert Sorted List to Binary Search Tree
    *
    * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
    *
    *
    * */

    public TreeNode sortedListToBST(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head == null) return null;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        while (head!=null){
            arrayList.add(head.val);
            head = head.next;
        }

        int[] num = new int[arrayList.size()];
        for (int i = 0; i<arrayList.size(); i++){
            num[i] = arrayList.get(i);
        }

        return sortedArrayToBST(num);
    }

    private TreeNode sortedArrayToBST(int[] num){
        if (num.length < 1) return null;

        Integer edge = new Integer(num.length/2);
        TreeNode root = new TreeNode(num[edge]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(num, 0, edge));
        root.right = sortedArrayToBST(Arrays.copyOfRange(num, edge + 1, num.length));
        return root;
    }

 }
