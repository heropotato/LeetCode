import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/28/13
 * Time: 11:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class partitionPartitioning {

    /*
    *
    * Palindrome Partitioning
    *
    * Given a string s, partition s such that every substring of the partition is a palindrome.
    *
    * Return all possible palindrome partitioning of s.
    *
    * For example, given s = "aab",
    * Return
    *
    * [
    *   ["aa","b"],
    *   ["a","a","b"]
    * ]
    *
    *
    *
    * */

    public ArrayList<ArrayList<String>> partition(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        // get inspired from http://yucoding.blogspot.com/2013/08/leetcode-question-132-palindrome.html
        // recursion solution:
        //
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        partition(s, 0, new ArrayList<String>(), res);
        return res;
    }

    private void partition(String s, int startIndex, ArrayList<String> curCombo, ArrayList<ArrayList<String>> res){
        if (startIndex >= s.length()) res.add(new ArrayList<String>(curCombo));
        else {
            for (int i = startIndex; i<s.length(); i++){
                if (isPalindrome(s, startIndex, i)){
                    curCombo.add(s.substring(startIndex, i+1));
                    partition(s, i+1, curCombo, res);
                    curCombo.remove(curCombo.size()-1);
                }
            }
        }
    }

    private boolean isPalindrome(String string, int startIndex, int endIndex){
        while (startIndex<endIndex){
            if (string.charAt(startIndex)!=string.charAt(endIndex)) return false;
            startIndex++;
            endIndex--;
        }
        return true;
    }
 }
