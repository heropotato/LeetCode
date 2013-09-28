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

        int lengthPerWord = L[0].length();
        int blockSize = lengthPerWord * L.length;
        if (S.length() < blockSize) return res;

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (String str : L) {
            if (hashMap.containsKey(str)) {
                hashMap.put(str, hashMap.get(str) + 1);
            } else {
                hashMap.put(str, 1);
            }
        }

        int i = 0;
        while (i <= S.length() - blockSize) {
            int runner = i;
            HashMap<String, Integer> tempHashMap = new HashMap<String, Integer>(hashMap);
            while (runner - i < blockSize) {
                String temp = S.substring(runner, runner + lengthPerWord);
                if (tempHashMap.containsKey(temp.toString())) {
                    int num = tempHashMap.get(temp.toString());
                    if (num == 1) {
                        tempHashMap.remove(temp.toString());
                    } else {
                        tempHashMap.put(temp.toString(), num - 1);
                    }
                    if (tempHashMap.isEmpty()) {
                        res.add(i);
                        break;
                    }
                    runner += lengthPerWord;
                } else {
                    break;
                }
            }
            i++;
        }

        return res;
    }

}
