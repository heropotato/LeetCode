import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/25/13
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class reverseKGroup {

    /*
    *
    * Reverse Nodes in k-Group
    *
    * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
    * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
    *
    * For example,
    *
    * Given this linked list: 1->2->3->4->5
    *
    * For k = 2, you should return: 2->1->4->3->5
    * For k = 3, you should return: 3->2->1->4->5
    *
    * */

     public ListNode reverseKGroup(ListNode head, int k) {

        // A simple recursion solution
        if (k < 2 || head == null || head.next == null) return head;

        ListNode current = head;
        ListNode tail = current;
        ListNode rest = current.next;
        int count = 1;
        while (rest != null){
            rest = rest.next;
            tail = tail.next;
            count++;
            if (count == k) break;
        }
        if (count < k) return head;
        tail.next=null;
        ListNode res = null;
        while (current!=null){
            ListNode temp = current;
            current = current.next;
            temp.next = res;
            res = temp;
        }
        head.next = reverseKGroup(rest, k);
        return res;
    }
}
