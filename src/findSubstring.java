import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/27/13
 * Time: 12:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class findSubstring {

    /*
    *
    * Substring with Concatenation of All Words
    *
    * You are given a string, S, and a list of words, L, that are all of the same length.
    *
    * Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
    *
    * For example, given:
    *
    * S: "barfoothefoobarman"
    * L: ["foo", "bar"]
    *
    * You should return the indices: [0,9].
    *
    * */

    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (S.isEmpty() || L.length == 0) return res;

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (String s : L) {
            if (hashMap.containsKey(s)) hashMap.put(s, hashMap.get(s) + 1);
            else hashMap.put(s, 1);
        }

        for (int i = 0; i <= S.length() - (L.length * L[0].length()); i++) {
            String current = S.substring(i, i + L.length * L[0].length());
            HashMap<String, Integer> test = new HashMap<String, Integer>(hashMap);
            for (int j = 0; j <= (L.length - 1) * L[0].length(); j = j + L[0].length()) {
                String word = current.substring(j, j + L[0].length());
                if (!test.containsKey(word)) break;
                if (test.get(word) == 1) test.remove(word);
                else test.put(word, test.get(word) - 1);
            }
            if (test.size() == 0) res.add(i);
        }
        return res;
    }

}
