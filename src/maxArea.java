/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/22/13
 * Time: 11:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class maxArea {

    /*
    *
    * Container With Most Water
    *
    * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
    *
    * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
    *
    * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
    *
    * Note: You may not slant the container.
    *
    *
    *
    * */

    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // Use two pointer for scanning height[] from outside in
        // The lower height vertical line will limit volume of current container
        // Always move the lower one outside in to try to find greater container volume

        if (height.length < 2) return 0;
        int maxArea = 0, leftP = 0, rightP = height.length - 1;

        while (leftP < rightP) {
            int temp = Math.min(height[leftP], height[rightP]) * (rightP - leftP);
            maxArea = Math.max(temp, maxArea);
            if (height[leftP] > height[rightP]) rightP--;
            else leftP++;
        }

        return maxArea;
    }
}
