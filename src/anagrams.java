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
    * Note: All inputs will be in lower-case.
    *
    * */

    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for (String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (map.containsKey(sorted)){
                map.get(sorted).add(str);
            }else {
                ArrayList<String> newGroup = new ArrayList<String>();
                newGroup.add(str);
                map.put(sorted, newGroup);
            }
        }

        for (String sorted:map.keySet()){
            if (map.get(sorted).size()>1) res.addAll(map.get(sorted));
        }

        return res;
    }

}
