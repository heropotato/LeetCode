import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/26/13
 * Time: 2:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class findLadders {

    /*
    *
    * Word Ladder II
    *
    * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
    *
    * Only one letter can be changed at a time
    * Each intermediate word must exist in the dictionary
    * For example,
    *
    *
    * Given:
    * start = "hit"
    * end = "cog"
    * dict = ["hot","dot","dog","lot","log"]
    * Return
    *
    * [
    *   ["hit","hot","dot","dog","cog"],
    *   ["hit","hot","lot","log","cog"]
    * ]
    *
    * Note:
    * All words have the same length.
    * All words contain only lowercase alphabetic characters.
    *
    *
    * */

     public int ladderLength(String start, String end, HashSet<String> dict) {
        if (start.length() != end.length()) return 0;
        if (start.equals("")) return 1;
        if (dict.size() == 0) return 0;
        int count = 1;
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();
        queue.add(start);
        queue.add(null);

        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (str != null) {
                for (int i = 0; i < str.length(); i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j == str.charAt(i)) continue;
                        char[] temp = str.toCharArray();
                        temp[i] = j;
                        String newString = new String(temp);
                        if (newString.equals(end)) return count+1;
                        if (dict.contains(newString)) {
                            queue.add(newString);
                            dict.remove(newString);
                        }
                    }
                }
            } else {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    count++;
                }
            }
        }

        return 0;
    }
}
