import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/25/13
 * Time: 11:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class mergeKLists {

    /*
    *
    * Merge k Sorted Lists
    *
    * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
    *
    * */

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // Time complexity: O(n^2), Space complexity: constant
        if (lists.size() < 2) return lists.size() == 0 ? null : lists.get(0);
        ListNode res = null;
        for (ListNode cur : lists) {
            while (cur != null) {
                ListNode add = cur;
                cur = cur.next;
                add.next = null;
                res = add(res, add);
            }
        }
        return res;
    }

    private ListNode add(ListNode res, ListNode add) {
        if (res == null || add.val <= res.val){
            add.next = res;
            return add;
        }
        ListNode slow = res;
        ListNode fast = res.next;
        while (fast != null) {
            if (add.val <= fast.val && add.val >= slow.val) {
                slow.next = add;
                add.next = fast;
                return res;
            }
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = add;
        return res;
    }
}
