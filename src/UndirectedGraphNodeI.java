import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/28/13
 * Time: 6:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class UndirectedGraphNodeI {

    /*
    *
    * Clone Graph
    *
    *
    * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
    *
    * OJ's undirected graph serialization:
    * Nodes are labeled uniquely.
    *
    * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
    * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
    *
    * The graph has a total of three nodes, and therefore contains three parts as separated by #.
    *
    * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
    * Second node is labeled as 1. Connect node 1 to node 2.
    * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
    * Visually, the graph looks like the following:
    *
    *
    *       1
    *      / \
    *     /   \
    *    0 --- 2
    *         / \
    *         \_/
    *
    *
    *
    * */


    /**
     * Definition for undirected graph.
     * class UndirectedGraphNode {
     * int label;
     * ArrayList<UndirectedGraphNode> neighbors;
     * UndirectedGraphNode(int x) {
     * label = x;
     * neighbors = new ArrayList<UndirectedGraphNode>();
     * }
     * };
     */


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        // get inspired from http://jane4532.blogspot.com/2013/09/clone-graphleetcode.html
        // BFS solution:
        // a basic BFS solution, in addition, create a HashMap<UndirectedGraphNode, UndirectedGraphNode> to track visited node for avoiding infinite loop scenarios
        // offer new node into the queue only when it dose NOT exist in HashMap
        if (node == null) return null;
        LinkedBlockingQueue<UndirectedGraphNode> queue = new LinkedBlockingQueue<UndirectedGraphNode>();
        queue.offer(node);
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> nodeHashSet = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        nodeHashSet.put(node, res);

        while (!queue.isEmpty()) {
            UndirectedGraphNode currentNode = queue.poll();
            for (UndirectedGraphNode neighbor : currentNode.neighbors) {
                if (!nodeHashSet.containsKey(neighbor)) {
                    UndirectedGraphNode n = new UndirectedGraphNode(neighbor.label);
                    nodeHashSet.get(currentNode).neighbors.add(n);
                    nodeHashSet.put(neighbor, n);
                    queue.offer(neighbor);
                } else {
                    nodeHashSet.get(currentNode).neighbors.add(nodeHashSet.get(neighbor));
                }
            }
        }

        return res;
    }
}
