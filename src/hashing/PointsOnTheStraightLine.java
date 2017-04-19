package hashing;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/points-on-the-straight-line/
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

 Sample Input :

 (1, 1)
 (2, 2)
 Sample Output :

 2
 You will be give 2 arrays X and Y. Each point is represented by (X[i], Y[i])

 */


public class PointsOnTheStraightLine {
    public int maxPoints(List<Integer> a, List<Integer> b) {

        if (a.size() <= 2) {
            return a.size();
        }

        int maxTillNow = 2;
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                int thisMax = 2;
                for (int k = 0; k < a.size(); k++) {
                    if (k != i && k != j) {
                        boolean isKOnLine = isLyingOnLine(a.get(i), b.get(i), a.get(j), b.get(j), a.get(k), b.get(k));
                        if (isKOnLine)
                            thisMax++;
                    }
                }
                maxTillNow = (thisMax > maxTillNow) ? thisMax : maxTillNow;
            }
        }
        return maxTillNow;
    }

    public boolean isLyingOnLine(int x1, int y1, int x2, int y2, int x, int y) {
        return Double.compare(getSlope(x1, y1, x2, y2), getSlope(x2, y2, x, y)) == 0;
    }

    public double getSlope(int x1, int y1, int x2, int y2) {
        if (x1 == x2)
            return Integer.MAX_VALUE;
        else if(y1 == y2 )
            return 0;
        double f = (((double)(y1 - y2)) / (x1 - x2));
        //System.out.println("slope is : " + f);
        return (f);
    }

    public static void main(String[] args) {

        System.out.println(new PointsOnTheStraightLine().maxPoints(Arrays.asList(4,8, -4), Arrays.asList(-4, -4, -4)));
        //System.out.println(new PointsOnTheStraightLine().getSlope(0,0, -1, 1));
    }                                                                                               //-6 -17 5 -16 -18 -17 2 -4 5 -13 -2 20;

}
