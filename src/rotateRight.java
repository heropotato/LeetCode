/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/10/13
 * Time: 4:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class rotateRight {

    /*
    *
    * Rotate List
    *
    * Given a list, rotate the list to the right by k places, where k is non-negative.
    *
    * For example:
    * Given 1->2->3->4->5->NULL and k = 2,
    * return 4->5->1->2->3->NULL.
    *
    *
    *
    * */

    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function

        //rotate to right 1 position per round
        if (head == null || head.next == null || n == 0) return head;
        ListNode current = head;
        ListNode runner = head.next;

        while (runner.next != null) {
            current = current.next;
            runner = runner.next;
        }

        current.next = null;
        runner.next = head;
        return rotateRight(runner, n - 1);
    }
}
