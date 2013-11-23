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
        // then use HashMap<Double, Integer> to count all points on a line, which start from the root point with the same slope
        // track slope values is a little tricky, use double primitive data type properly

        int res = 0;
        HashMap<Double, Integer> slopeCounts = new HashMap<Double, Integer>();
        for (int i = 0; i < points.length; i++) {
            slopeCounts.clear();
            int vertical = 0, horizon = 0, sameRoot = 0;
            for (int j = i; j < points.length; j++) {
                if (points[j].y == points[i].y && points[j].x == points[i].x) {
                    sameRoot++;
                } else {
                    if (points[j].x == points[i].x) vertical++;
                    else if (points[j].y == points[i].y) horizon++;
                    else {
                        double slope = ((double) (points[j].y - points[i].y)) / ((double) (points[j].x - points[i].x));
                        if (slopeCounts.containsKey(slope)) slopeCounts.put(slope, slopeCounts.get(slope) + 1);
                        else slopeCounts.put(slope, 1);
                    }
                }
            }
            for (Integer slope : slopeCounts.values()) if (slope + sameRoot > res) res = slope + sameRoot;
            if (vertical + sameRoot > res || horizon + sameRoot > res)
                res = Math.max(vertical + sameRoot, horizon + sameRoot);
        }
        return res;
    }
}
