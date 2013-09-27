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
    *
    * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
    *
    * For example,
    *
    * Given this linked list: 1->2->3->4->5
    *
    * For k = 2, you should return: 2->1->4->3->5
    *
    * For k = 3, you should return: 3->2->1->4->5
    *
    *
    * */

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2 || head == null) return head;

        Stack<ListNode> reversePart = new Stack<ListNode>();
        ListNode current = head;
        ListNode newHead = null;
        ListNode pointer = null;

        while (current != null) {
            int count = 0;

            while (count<k){
                if(current == null){
                    if(newHead == null) return head;
                    return newHead;
                }
                reversePart.push(current);
                current = current.next;
                count++;
            }

            while (!reversePart.isEmpty()) {
                if (newHead == null) {
                    newHead = reversePart.pop();
                    pointer = newHead;
                } else {
                    pointer.next = reversePart.pop();
                    pointer = pointer.next;
                }
            }
            pointer.next = current;
        }
        return newHead;
    }
 }
