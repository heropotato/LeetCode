/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/29/13
 * Time: 9:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class hasCycle {

    /*
    *
    * Linked List Cycle
    *
    * Given a linked list, determine if it has a cycle in it.
    *
    *
    * Follow up:
    * Can you solve it without using extra space?
    *
    * */

    public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        // a classic interview question
        // one neat solution runs in O(N) time complexity and O(1) spaces
        // two runner solution: one runner moves one step per round while the other one moves two steps per round
        // in case of a cycle existed in the given list, somehow two runners will meet each other at a node
        // otherwise the fast runner will reach the end of list NULL

        if (head == null || head.next == null) return false;
        ListNode slowRunner = head, fastRunner = head;
        while (slowRunner != null && fastRunner!= null){
            slowRunner = slowRunner.next;
            if (fastRunner.next != null)fastRunner = fastRunner.next.next;
            else return false;
            if (fastRunner == slowRunner) return true;
        }
        return false;
    }
 }
