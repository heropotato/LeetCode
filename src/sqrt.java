/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/11/13
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class sqrt {

    /*
    *
    * Sqrt(x)
    *
    * Implement int sqrt(int x).
    *
    * Compute and return the square root of x.
    *
    *
    * */

    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long bottom = 0, top = x;
        while (top >= bottom) {
            long midVal = bottom + (top - bottom) / 2;
            if (x < midVal * midVal) top = midVal-1;
            else bottom = midVal+1;
        }
        return (int) top;
    }
}
