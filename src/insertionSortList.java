import java.util.Stack;

/**
 * Created by yongwen on 11/13/13.
 */
public class insertionSortList {

    /*
    *
    * Insertion Sort List
    *
    * Sort a linked list using insertion sort.
    *
    * */

    public ListNode insertionSortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        // According to the characteristics of Linked List,
        // Do insertion sort from the tail to the head (it's easy to find next node and hard to get the previous node)
        // The tricky part is: swap the value between nodes rather than literally swap nodes

        if (head == null || head.next == null) return head;
        ListNode current = head;
        Stack<ListNode> prevPath = new Stack<ListNode>();
        while (current!=null) {
            prevPath.push(current);
            current = current.next;
        }
        // reached tail of the list
        while (!prevPath.isEmpty()){
            current = prevPath.pop();
            while (current!=null && current.next!=null){
                if (current.val>current.next.val) swapValue(current, current.next);
                current = current.next;
            }
        }

        return head;
    }

    private void swapValue(ListNode a, ListNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
