import java.util.*;
import java.util.regex.Matcher;

/**
 * Created by yongwen on 11/22/13.
 */
public class maxPoints {

    /*
    *
    * Max Points on a Line
    *
    * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
    *
    *
    *
    * Definition for a point.
    * class Point {
    *     int x;
    *     int y;
    *     Point() { x = 0; y = 0; }
    *     Point(int a, int b) { x = a; y = b; }
    * }
    *
    * */

    public int maxPoints(Point[] points) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        // Pretty straightforward:
        // iterate points array, for each point, calculate each right-hand side point in manner of slope,
        // then use HashMap<Double, Integer> to count points has the same slope against current point
        // calculate slope is a little tricky, use double properly as primitive data type

        if (points.length == 0) return 0;
        int res = 0;
        HashMap<Double, Integer> counts = new HashMap<Double, Integer>();
        for (int i = 0; i < points.length; i++) {
            counts.clear();
            int vertical = 0, horizon = 0, duplicate = 0;
            for (int j = i; j < points.length; j++) {
                if (points[j].y == points[i].y && points[j].x == points[i].x) {
                    duplicate++;
                } else {
                    if (points[j].x == points[i].x){
                        vertical++;
                    }else if (points[j].y == points[i].y){
                        horizon++;
                    } else {
                        Double slope = ((double) (points[j].y - points[i].y)) / ((double) (points[j].x - points[i].x));
                        if (counts.containsKey(slope)) counts.put(slope, counts.get(slope) + 1);
                        else counts.put(slope, 1);
                    }
                }
            }
            for (Integer count : counts.values()) if (count + duplicate> res) res = count + duplicate;
            if (vertical + duplicate> res) res = vertical + duplicate;
            if (horizon + duplicate > res) res = horizon + duplicate;
        }
        return res;
    }
}
