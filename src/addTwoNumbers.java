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
        // Start typing your Java solution below
        // DO NOT write main() function

        return parseLinkedList(parseNumber(l1) + parseNumber(l2));

    }

    public long parseNumber(ListNode head) {

        long result = 0, times = 1;
        ListNode current = head;

        while (current != null) {

            long temp = current.val * times;
            result = result + temp;
            current = current.next;
            times = times * 10;
        }

        return result;
    }

    public ListNode parseLinkedList(long input) {

        char[] resultArray = String.valueOf(input).toCharArray();
        ListNode result = null;

        for (int i = 0; i < resultArray.length; i++) {

            int temp = Character.getNumericValue(resultArray[i]);
            ListNode newHead = new ListNode(temp);
            newHead.next = result;
            result = newHead;

        }

        return result;

    }
}
