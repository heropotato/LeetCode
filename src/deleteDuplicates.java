/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/15/13
 * Time: 10:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class deleteDuplicates {

    /*
    *
    * Remove Duplicates from Sorted List
    *
    * Given a sorted linked list, delete all duplicates such that each element appear only once.
    *
    *
    * For example,
    *
    * Given 1->1->2, return 1->2.
    *
    * Given 1->1->2->3->3, return 1->2->3.
    *
    * */

    public ListNode deleteDuplicates(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head == null || head.next == null) return head;

        ListNode current = head;
        while (current != null && current.next != null){
            if(current.val == current.next.val) current.next = current.next.next;
            else current = current.next;
        }

        return head;
    }
 }
