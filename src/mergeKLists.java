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

        if (lists.size()<2) return lists.size()==0?null:lists.get(0);
        ListNode res = lists.get(0);
        ListNode ori = res;
        for (int i = 1; i<lists.size();i++){
            ListNode cur = lists.get(i);
            while (cur!=null){
                ListNode add = cur;
                cur = cur.next;
                add.next = null;
                ori = add(ori, add);
            }
        }
        return ori;
    }

    private ListNode add(ListNode ori, ListNode add){
        if (ori == null) return add;
        ListNode slow = ori;
        ListNode fast = ori.next;
        while (fast!=null){
            if (add.val < slow.val){
                add.next = slow;
                return add;
            }
            if (add.val <= fast.val && add.val >= slow.val){
                slow.next = add;
                add.next = fast;
                return ori;
            }
            slow = slow.next;
            fast = fast.next;
        }
        if (slow.val <= add.val){
            slow.next = add;
            return ori;
        }
        else {
            add.next = slow;
            return add;
        }
    }
}
