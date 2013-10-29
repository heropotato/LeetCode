import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/29/13
 * Time: 12:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class wordBreak {

    /*
    *
    * Word Break
    *
    * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
    *
    * For example, given
    * s = "leetcode",
    * dict = ["leet", "code"].
    *
    * Return true because "leetcode" can be segmented as "leet code".
    *
    * */

    public boolean wordBreak(String s, Set<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        // DP solution:

        if (s.isEmpty() || dict.isEmpty()) return false;
        boolean[] path = new boolean[s.length() + 1];
        path[0] = true;

        for (int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (path[start] && dict.contains(s.substring(start, end))) path[end] = true;
            }
        }

        return path[s.length()];
    }
}
