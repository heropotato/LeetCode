/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/25/13
 * Time: 3:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class swapPairs {

    /*
    *
    * Swap Nodes in Pairs
    *
    * Given a linked list, swap every two adjacent nodes and return its head.
    *
    * For example,
    * Given 1->2->3->4, you should return the list as 2->1->4->3.
    *
    * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
    *
    * */

    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (head == null || head.next == null) return head;

        ListNode rest = swapPairs(head.next.next);
        ListNode second = head.next;
        head.next = rest;
        second.next = head;

        return second;
    }

}
