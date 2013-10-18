/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/18/13
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class partition {

    /*
    *
    * Partition List
    *
    * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
    *
    * You should preserve the original relative order of the nodes in each of the two partitions.
    *
    * For example,
    * Given 1->4->3->2->5->2 and x = 3,
    * return 1->2->2->4->3->5.
    *
    *
    * */

    public ListNode partition(ListNode head, int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode firstHalf = new ListNode(0);
        ListNode firstRunner = firstHalf;
        ListNode secondHalf = new ListNode(0);
        ListNode secondRunner = secondHalf;

        if(head == null) return head;
        if(head.next == null) return head;

        while (head!= null){
            if(head.val<x){
                firstRunner.next = new ListNode(head.val);
                firstRunner = firstRunner.next;
            }else {
                secondRunner.next = new ListNode(head.val);
                secondRunner = secondRunner.next;
            }
            head = head.next;
        }
        firstRunner.next = secondHalf.next;
        return firstHalf.next;
    }
 }
