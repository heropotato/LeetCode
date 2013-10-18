import java.util.Hashtable;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/18/13
 * Time: 4:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class isScramble {

    /*
    *
    * Scramble String
    *
    * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
    *
    * Below is one possible representation of s1 = "great":
            great
           /    \
          gr    eat
         / \    /  \
        g   r  e   at
                   / \
                  a   t
        To scramble the string, we may choose any non-leaf node and swap its two children.

        For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

            rgeat
           /    \
          rg    eat
         / \    /  \
        r   g  e   at
                   / \
                  a   t
        We say that "rgeat" is a scrambled string of "great".

        Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

            rgtae
           /    \
          rg    tae
         / \    /  \
        r   g  ta  e
               / \
              t   a
        We say that "rgtae" is a scrambled string of "great".

        Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
    *
    *
    *
    * */

    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Hashtable<String, Boolean> booleanHistory = new Hashtable<String, Boolean>();
        return isScramble(s1, s2, booleanHistory);

    }

    private boolean isScramble(String s1, String s2, Hashtable<String, Boolean> booleanHistory) {
        String temp;
        if (s1.compareTo(s2) > 0) temp = s1 + s2;
        else temp = s2 + s1;

        if (booleanHistory.containsKey(temp))
            return booleanHistory.get(temp);
        else {
            int length = s1.length();
            if (length != s2.length()) {
                booleanHistory.put(temp, false);
                return false;
            }

            if (length == 1) {
                booleanHistory.put(temp, s1.charAt(0) == s2.charAt(0));
                return s1.charAt(0) == s2.charAt(0);
            }

            if (s1.equals(s2)) {
                booleanHistory.put(temp, true);
                return true;
            }

            for (int i = 1; i < length; i++) {
                String s1FHalf = s1.substring(0, i);
                String s1SHalf = s1.substring(i);
                String s2FHalf = s2.substring(0, i);
                String s2SHalf = s2.substring(i);
                if ((isScramble(s1FHalf, s2FHalf, booleanHistory) && isScramble(s1SHalf, s2SHalf, booleanHistory)) || (isScramble(s1.substring(length - i), s2FHalf, booleanHistory) && isScramble(s1.substring(0, length - i), s2SHalf, booleanHistory))) {
                    booleanHistory.put(temp, true);
                    return true;
                }
            }

            booleanHistory.put(temp, false);
            return false;
        }

    }

}
