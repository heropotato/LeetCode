/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/24/13
 * Time: 9:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class removeNthFromEnd {

    /*
    *
    * Remove Nth Node From End of List
    *
    * Given a linked list, remove the nth node from the end of list and return its head.
    *
    *
    * For example,
    *
    * Given linked list: 1->2->3->4->5, and n = 2.
    *
    * After removing the second node from the end, the linked list becomes 1->2->3->5.
    *
    *
    * */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode newList = new ListNode(Integer.MAX_VALUE);
        ListNode current = head, preDelete = newList;
        newList.next = head;

        while(n>0 && current!=null){
            current = current.next;
            n--;
        }

        while(current != null){
            current = current.next;
            preDelete = preDelete.next;
        }

        if(preDelete.next != null) preDelete.next = preDelete.next.next;
        return newList.next;
    }

 }
