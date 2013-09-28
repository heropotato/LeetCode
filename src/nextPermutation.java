import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/28/13
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class nextPermutation {

    /*
    *
    * Next Permutation
    *
    * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
    *
    * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
    *
    * The replacement must be in-place, do not allocate extra memory.
    *
    *
    *
    * */


    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int length = num.length;
        if (length < 2) return;

        //Step 1: (from right to left), find the 1st element violating 'increase trend'. If not, rearrange in ascending order
        //Step 2: (from right to left), find the 1st element, calling ChangeNumber which is greater than the Violator
        //Step 3: swap elements of 1 and 2 step
        //Step 4: reverse all elements behind Violator index

        int i = length - 1;
        ArrayList<Integer> res = new ArrayList<Integer>();

        while (i > 0) {
            int runner = i - 1;
            if (num[runner] < num[i]) {
                res.add(runner);
                break;
            }
            i--;
        }

        if (res.size() == 1) {
            int j = length - 1;
            while (j > res.get(0)) {
                if (num[j] > num[res.get(0)]) {
                    res.add(j);
                    break;
                }
                j--;
            }
        }

        if (res.size() == 2) {
            nextPermutation(num, res.get(0), res.get(1));
            nextPermutationReverse(num, res.get(0) + 1);
        }

        if (res.size() == 0) nextPermutationReverse(num, 0);
        return;
    }

    private void nextPermutation(int[] num, int violator, int change) {
        int temp = num[change];
        num[change] = num[violator];
        num[violator] = temp;
        return;
    }

    private void nextPermutationReverse(int[] num, int change) {

        int last = num.length - 1;

        while (change < last) {
            int temp = num[change];
            num[change] = num[last];
            num[last] = temp;
            change++;
            last--;
        }
        return;
    }

}
