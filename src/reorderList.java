
/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 11/3/13
 * Time: 7:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class reorderList {

    /*
    *
    * Reorder List
    *
    *
    * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
    *
    * You must do this in-place without altering the nodes' values.
    *
    * For example,
    * Given {1,2,3,4}, reorder it to {1,4,2,3}.
    *
    * */

    public void reorderList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        // find out the middle node of current list, then split list into first half and second half
        // reverse the second half
        // add each one of second half to the first half according to the question

        int length = 0, preLength = 1;
        ListNode current = head, end = head;
        while (current != null) {
            length++;
            current = current.next;
            if (length - preLength == 2) {
                preLength = length;
                end = end.next;
            }
        }
        if (length < 3) return;
        if ((length - 1) % 2 != 0) end = end.next;
        current = end.next;
        end.next = null;

        ListNode sufRunner = reverseList(current);
        ListNode preRunner = head;

        while (sufRunner != null) {
            ListNode add = sufRunner;
            sufRunner = sufRunner.next;

            ListNode addTo = preRunner;
            preRunner = preRunner.next;

            addTo.next = add;
            add.next = preRunner;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode newHead = null;
        while (current != null) {
            ListNode temp = current;
            current = current.next;
            temp.next = newHead;
            newHead = temp;
        }
        return newHead;
    }
}
