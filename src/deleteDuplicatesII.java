/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/15/13
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class deleteDuplicatesII {

    /*
    *
    * Remove Duplicates from Sorted List II
    *
    * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
    *
    *
    *
    * For example,
    *
    * Given 1->2->3->3->4->4->5, return 1->2->5.
    *
    * Given 1->1->1->2->3, return 2->3.
    *
    * */

    public ListNode deleteDuplicates(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head == null || head.next == null) return head;

        ListNode newHead = new ListNode(0);
        ListNode pre = newHead;
        ListNode current = head;
        ListNode runner = head;

        while (runner != null && runner.next != null) {
            while (runner.next != null && runner.val == runner.next.val) {
                runner = runner.next;
            }

            if (current == runner) {
                pre.next = current;
                pre = pre.next;
            }

            current = runner.next;
            runner = runner.next;
        }

        pre.next = current;
        return newHead.next;
    }
}
