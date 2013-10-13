import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/5/13
 * Time: 1:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class anagrams {

    /*
    *
    * Anagrams
    *
    * Given an array of strings, return all groups of strings that are anagrams.
    *
    * Note: All inputs will be in lower-case.
    *
    * */

    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<String> res = new ArrayList<String>();
        HashSet<Integer> indexes = new HashSet<Integer>();
        HashMap<String, Integer> patterns = new HashMap<String, Integer>();
        int[] emptyString = new int[2];
        emptyString[0] = 0;

        int i = 0;
        for (String str : strs) {
            if (str.isEmpty()) {
                if (emptyString[0] == 0) {
                    emptyString[0] = 1;
                    emptyString[1] = i;
                } else {
                    if (indexes.add(emptyString[1])) res.add("");
                    res.add("");
                    indexes.add(i);
                }
            } else {
                char[] temp = str.toCharArray();
                Arrays.sort(temp);
                if (!patterns.containsKey(new String(temp))) {
                    patterns.put(new String(temp), i);
                } else {
                    if (indexes.add(patterns.get(new String(temp)))) res.add(strs[patterns.get(new String(temp))]);
                    res.add(str);
                    indexes.add(i);
                }
            }
            i++;
        }
        return res;
    }

}
