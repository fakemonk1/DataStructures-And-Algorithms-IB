package twopointers;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/container-with-most-water/
 * Given n non-negative integers a1, a2, ..., an,
 where each represents a point at coordinate (i, ai).
 'n' vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).

 Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Your program should return an integer which corresponds to the maximum area of water that can be contained ( Yes, we know maximum area instead of maximum volume sounds weird. But this is 2D plane we are working with for simplicity ).
 Example :

 Input : [1, 5, 4, 3]
 Output : 6

 Explanation : 5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3.
 So total area = 3 * 2 = 6
 */


public class ContainerWithMostWater {
    public int maxArea(ArrayList<Integer> a) {
        if(a.size() <= 1){
            return 0;
        }
        int l = 0;
        int r = a.size() - 1;
        int maxTillNow = 0;
        while (l < r) {
            int area = (r-l)*Math.min(a.get(l), a.get(r));
            maxTillNow = Math.max(maxTillNow, area);
            if(a.get(l)< a.get(r)){
                l++;
            }else{
                r--;
            }
        }
        return maxTillNow;
    }
}
