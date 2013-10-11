/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/11/13
 * Time: 1:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class mergeTwoLists {

    /*
    *
    * Merge Two Sorted Lists
    *
    * Merge two sorted linked lists and return it as a new list.
    *
    * The new list should be made by splicing together the nodes of the first two lists.
    *
    *
    * */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode res = new ListNode(1);
        ListNode runner = res;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                runner.next = l1;
                l1 = l1.next;
            } else {
                runner.next = l2;
                l2 = l2.next;
            }
            runner = runner.next;
        }

        if (l1 == null) runner.next = l2;
        if (l2 == null) runner.next = l1;
        return res.next;
    }
}
