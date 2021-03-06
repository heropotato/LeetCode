/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 11/1/13
 * Time: 1:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class detectCycle {

    /*
    *
    * Linked List Cycle II
    *
    *
    * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
    *
    * Follow up:
    * Can you solve it without using extra space?
    *
    * */

    public ListNode detectCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        // based on the solution of "Linked List Cycle", determine whether there is a cycle exists
        // if so, add one more runner which starts from the head
        // let the slow runner run in the cycle (start from and end in fast runner position),
        // for each round, if slow runner meets the third runner, then the position is where cycle starts
        // otherwise, the third runner move forward one step, and let slow runner run another round.
        ListNode runS = head, runF = head;

        while (runS != null && runF != null) {
            runS = runS.next;
            if (runF.next != null) runF = runF.next.next;
            else return null;
            if (runS == runF) break;
        }
        if (runS!=runF) return runF;

        ListNode startCycle = head;
        while (runS != startCycle) {
            if (runS.next == runF) startCycle = startCycle.next;
            runS = runS.next;
        }
        return startCycle;
    }
}
