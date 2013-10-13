/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/5/13
 * Time: 11:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class pow {

    /*
    *
    * Pow(x, n)
    *
    * Implement pow(x, n)
    *
    * */


    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }

        if (n % 2 == 0) {
            double temp = pow(x, n / 2);
            return temp * temp;
        } else {
            double temp = pow(x, (n - 1) / 2);
            return x * temp * temp;
        }
    }

}
