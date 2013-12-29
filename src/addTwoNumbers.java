/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/13/13
 * Time: 11:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class addTwoNumbers {

    /*
    *
    * May 15, 2013
    *
    * Add Two Numbers
    *
    * You are given two linked lists representing two non-negative numbers.
    * The digits are stored in reverse order and each of their nodes contain a single digit.
    * Add the two numbers and return it as a linked list.
    *
    * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    *
    * Output: 7 -> 0 -> 8
    *
    * */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        while (l1 != null) {
            a.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            b.append(l2.val);
            l2 = l2.next;
        }

        long sum = Long.valueOf(a.reverse().toString()) + Long.valueOf(b.reverse().toString());
        a = new StringBuilder().append(sum).reverse();
        ListNode res = new ListNode(1);
        ListNode runner = res;
        for (char c : a.toString().toCharArray()) {
            runner.next = new ListNode(Character.getNumericValue(c));
            runner = runner.next;
        }
        return res.next;
    }
}
