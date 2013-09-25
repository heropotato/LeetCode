import java.util.ArrayList;
import java.util.Collections;

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
    *
    *
    * */

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ListNode res = new ListNode(0);

        if (lists.size() == 0) return null;
        if (lists.size() == 1) return lists.get(0);

        ArrayList<Integer> minQueue = new ArrayList<Integer>();

        for (ListNode list : lists) {
            while (list != null) {
                minQueue.add(list.val);
                list = list.next;
            }
        }

        Collections.sort(minQueue);
        ListNode pointer = res;

        for (Integer i : minQueue) {
            pointer.next = new ListNode(i);
            pointer = pointer.next;
        }

        return res.next;
    }
}
