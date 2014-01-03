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
    * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
    * The replacement must be in-place, do not allocate extra memory.
    *
    * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
    *
    * 1,2,3 → 1,3,2
    * 3,2,1 → 1,2,3
    * 1,1,5 → 1,5,1
    *
    * */

    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // What is 'Next Permutation':
        // Step 1: (from right to left) Find the Violator, which is the 1st element violating 'increase trend'; if no violator, reverse the entire array
        // Step 2: (from right to left) Find the Changer, which is the 1st element greater than the Violator
        // Step 3: swap Violator and Changer
        // Step 4: reverse all elements behind Violator index

        if (num.length < 2) return;
        ArrayList<Integer> found = new ArrayList<Integer>();

        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                found.add(i);
                int j = num.length -1;
                while (!(num[j] > num[i])) j--;
                found.add(j);
                break;
            }
        }

        if (found.isEmpty()) {
            reverse(num, 0); // no violator found, then reverse the entire array
        } else {
            swap(num, found.get(0), found.get(1));
            reverse(num, found.get(0) + 1);
        }
    }

    private void swap(int[] num, int violator, int change) {
        int temp = num[change];
        num[change] = num[violator];
        num[violator] = temp;
    }

    private void reverse(int[] num, int change) {
        for (int i = num.length - 1; i > change; i--, change++) swap(num, i, change);
    }
}
