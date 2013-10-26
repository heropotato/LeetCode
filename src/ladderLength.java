import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/26/13
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class ladderLength {

    /*
    *
    * Word Ladder
    *
    * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
    *
    *
    * Only one letter can be changed at a time
    * Each intermediate word must exist in the dictionary
    * For example,
    *
    * Given:
    * start = "hit"
    * end = "cog"
    * dict = ["hot","dot","dog","lot","log"]
    * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    * return its length 5.
    *
    * Note:
    * Return 0 if there is no such transformation sequence.
    * All words have the same length.
    * All words contain only lowercase alphabetic characters.
    *
    * */

     public int ladderLength(String start, String end, HashSet<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // get inspired from http://mattcb.blogspot.com/2013/02/word-ladder.html

        // a BFS solution
        Hashtable<String, String> path = new Hashtable<String, String>(); // tracking current string, prev string
        HashSet<String> visit = new HashSet<String>(); // avoid transforming to prev strings
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();
        queue.add(start);
        visit.add(start);
        while (!queue.isEmpty()) {
            String prev = queue.poll();
            for (String curr : getStrTransSet(prev, dict)) { // get all valid transformed strings (one char changed and existed in dict as well)
                if (curr.equals(end)) {
                    int count = 1;
                    while (prev != null) {
                        prev = path.get(prev);
                        count++;
                    }
                    return count;
                }
                if (!visit.contains(curr)) {
                    path.put(curr, prev);
                    visit.add(curr);
                    queue.add(curr);
                }
            }
        }
        return 0;
    }

    public HashSet<String> getStrTransSet(String str, HashSet<String> dict) {
        HashSet<String> strTransSet = new HashSet<String>();
        for (int i = 0; i < str.length(); i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                char[] strArr = str.toCharArray();
                if (strArr[i] != j) {
                    strArr[i] = j;
                    String temp = new String(strArr);
                    if (dict.contains(temp)) strTransSet.add(temp);
                }
            }
        }
        return strTransSet;
    }
}
