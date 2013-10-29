import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/29/13
 * Time: 12:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class copyRandomList {

    /*
    *
    * Copy List with Random Pointer
    *
    * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
    *
    * Return a deep copy of the list.
    *
    * */

    /**
     * Definition for singly-linked list with a random pointer.
     * class RandomListNode {
     * int label;
     * RandomListNode next, random;
     * RandomListNode(int x) { this.label = x; }
     * };
     */

    public RandomListNode copyRandomList(RandomListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        // BFS solution:
        // Quite similar to the question "Clone Graph"
        //
        // a basic BFS solution, in addition, create a HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping 'originalNode' to 'copiedNode'
        // offer new node into the queue only when its corresponding 'originalNode' dose NOT exist in HashMap

        if (head == null) return null;

        LinkedBlockingQueue<RandomListNode> queue = new LinkedBlockingQueue<RandomListNode>();
        HashMap<RandomListNode, RandomListNode> nodeHashMap = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        nodeHashMap.put(head, newHead);
        queue.offer(head);

        while (!queue.isEmpty()) {
            RandomListNode copyNode = queue.poll();
            if (copyNode.next == null) nodeHashMap.get(copyNode).next = null;
            else if (!nodeHashMap.containsKey(copyNode.next)) {
                RandomListNode nodeNext = new RandomListNode(copyNode.next.label);
                nodeHashMap.put(copyNode.next, nodeNext);
                queue.offer(copyNode.next);
                nodeHashMap.get(copyNode).next = nodeNext;
            } else {
                nodeHashMap.get(copyNode).next = nodeHashMap.get(copyNode.next);
            }
            if (copyNode.random == null) nodeHashMap.get(copyNode).random = null;
            else if (!nodeHashMap.containsKey(copyNode.random)) {
                RandomListNode nodeRandom = new RandomListNode(copyNode.random.label);
                nodeHashMap.put(copyNode.random, nodeRandom);
                queue.offer(copyNode.random);
                nodeHashMap.get(copyNode).random = nodeRandom;
            } else {
                nodeHashMap.get(copyNode).random = nodeHashMap.get(copyNode.random);
            }
        }
        return newHead;
    }
}
