/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/19/13
 * Time: 1:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class reverseBetween {

    /*
    *
    * Reverse Linked List II
    *
    * Reverse a linked list from position m to n. Do it in-place and in one-pass.
    *
    * For example:
    * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
    *
    * return 1->4->3->2->5->NULL.
    *
    * Note:
    * Given m, n satisfy the following condition:
    * 1 ≤ m ≤ n ≤ length of list.
    *
    *
    *
    * */

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null) return head;

        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode current = newHead;
        int i = m-1; // locate prev node of m position
        while (i>0){
            current = current.next;
            i--;
        }

        ListNode prevM = current;
        current = current.next;
        i = n-m;
        while (current!=null && i >0){
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = prevM.next;
            prevM.next = temp;
            i--;
        }

        return newHead.next;
    }

}
