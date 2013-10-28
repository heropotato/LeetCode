import java.util.Arrays;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/27/13
 * Time: 7:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class longestConsecutive {

    /*
    *
    * Longest Consecutive Sequence
    *
    * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
    *
    *
    * For example,
    * Given [100, 4, 200, 1, 3, 2],
    * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
    *
    * Your algorithm should run in O(n) complexity.
    *
    *
    * */

    public int longestConsecutive(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Arrays.sort(num);
        HashSet<Integer> historySet = new HashSet<Integer>();
        int curCon = 0, longestCon = 0;
        Integer prev = null;

        for (int i = 0; i<num.length; i++){
            if (prev == null) {
                prev = num[i];
                historySet.add(prev);
                curCon++;
                continue;
            }

            if (historySet.add(num[i])){
                if (num[i] == prev + 1){
                    curCon++;
                    if (curCon > longestCon) longestCon = curCon;
                }else {
                    longestCon = curCon>longestCon?curCon:longestCon;
                    curCon = 1;
                }
                prev = num[i];
            }

        }

        return curCon>longestCon?curCon:longestCon;
    }
 }
