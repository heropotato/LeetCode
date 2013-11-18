/**
 * Created by yongwen on 11/16/13.
 */
public class sortList {

    /*
    *
    * Sort List
    *
    * Sort a linked list in O(n log n) time using constant space complexity.
    *
    *
    * */

    public static ListNode sortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        // A typical MergeSort on singly linked list: divide and conquer
        if (head == null || head.next == null) return head;
        ListNode middleNode = divide(head);
        ListNode rightHalf = middleNode.next;
        middleNode.next = null;
        return merge(sortList(head), sortList(rightHalf));
    }

    private static ListNode divide(ListNode head){
        if (head == null) return head;
        ListNode slowRunner = head, fastRunner = head;
        while (fastRunner.next != null && fastRunner.next.next != null){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }
        return slowRunner;
    }

    private static ListNode merge(ListNode leftHalf, ListNode rightHalf){
        ListNode newHead = new ListNode(1), current = newHead;
        while (leftHalf!=null&&rightHalf!=null){
            if (leftHalf.val < rightHalf.val){
                current.next = leftHalf;
                leftHalf = leftHalf.next;
            }else {
                current.next = rightHalf;
                rightHalf = rightHalf.next;
            }
            current = current.next;
        }
        current.next = leftHalf==null?rightHalf:leftHalf;
        return newHead.next;
    }
}
