import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 5/12/13
 * Time: 1:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class twoSum {
    //May 12, 2013
    /*
    Two Sum
    Given an array of integers, find two numbers such that they add up to a specific target number.

    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

    You may assume that each input would have exactly one solution.

    Input: numbers={2, 7, 11, 15}, target=9
    Output: index1=1, index2=2
    */

    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.length; i++) {

            Integer diff = target - numbers[i];

            if (map.containsKey(diff)) {

                int temp = map.get(diff);

                if (i < temp) {
                    result[0] = i + 1;
                    result[1] = temp + 1;
                } else {
                    result[0] = temp + 1;
                    result[1] = i + 1;
                }
                break;
            }

            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], i);
            }

        }
        return result;
    }
}
