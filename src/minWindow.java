/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/12/13
 * Time: 11:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class minWindow {

    /*
    *
    * Minimum Window Substring
    *
    * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
    *
    * For example,
    * S = "ADOBECODEBANC"
    * T = "ABC"
    *
    * Minimum window is "BANC".
    *
    * Note:
    * If there is no such window in S that covers all characters in T, return the empty string "".
    *
    * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
    *
    *
    * */

    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function

        //get inspired from "Matt Huapeng's coding puzzle Blog ", http://mattcb.blogspot.com/2012/12/minimum-window-substring.html

        //each char is a 16 bit unsigned integer in Java
        //(The most tricky part! I used HashMap<Character, Integer> here for tracking chars and counting numbers of each char)
        //It cannot pass the large set test
        int[] setOfT = new int[256];
        int[] setOfS = new int[256];

        //iterate T, store count of each char at char(th unsigned 16 bit int) index
        for (char t : T.toCharArray()) {
            setOfT[t]++;
        }

        int startIndexOfCurrent = 0, countOfValidMatched = 0, minWindowLength = Integer.MAX_VALUE;
        String res = "";

        for (int i = 0; i < S.length(); i++) {
            char temp = S.charAt(i);
            //continue the loop if current char in S dose not appear in T
            if (setOfT[temp] == 0) continue;

            //setOfS tracks count of chars against setOfT only
            setOfS[temp]++;
            //countOfMatched counts each valid char appearance found in S
            if (setOfS[temp] <= setOfT[temp]) countOfValidMatched++;

            //once found all chars of T by far in S
            if (countOfValidMatched == T.length()) {
                char startCharOfCurrent = S.charAt(startIndexOfCurrent);

                //if current char counts is greater than char counts in T, move to the next char in currentCount
                while (setOfS[startCharOfCurrent] > setOfT[startCharOfCurrent] || setOfT[startCharOfCurrent] == 0) {
                    if (setOfS[startCharOfCurrent] > setOfT[startCharOfCurrent]) setOfS[startCharOfCurrent]--;
                    startIndexOfCurrent++;
                    startCharOfCurrent = S.charAt(startIndexOfCurrent);
                }

                //compare to previous minWindow length, assign the shorter to the res as answer
                if (minWindowLength > i + 1 - startIndexOfCurrent) {
                    minWindowLength = i + 1 - startIndexOfCurrent;
                    res = S.substring(startIndexOfCurrent, i + 1);
                }
            }
        }
        return res;
    }
}
