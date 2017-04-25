package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/jump-game-array/
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:A = [2,3,1,1,4], return 1 ( true )
 * A = [3,2,1,0,4], return 0 ( false ).
 * Return 0/1 for this problem
 */

public class JumpGameArray {
    boolean[] jumpArray;

    public int canJump(List<Integer> a) {
        if (a.size() == 1)
            return 1;
        jumpArray = new boolean[a.size()];
        Arrays.fill(jumpArray, false);
        //fill array
        int size = a.size();
        for (int i = size - 1; i >= 0; i--) {
            //can't jump at all
            if (a.get(i) == 0) {
                jumpArray[i] = false;
                //direct jump to end
            } else if (a.get(i) >= size - (i + 1)) {
                jumpArray[i] = true;
            } else {
                //if any of the right index reachable from this point are true, mark this true too
                for (int j = 1; j <= a.get(i); j++) {
                    if (jumpArray[i + j]) {
                        jumpArray[i] = true;
                        break;
                    }
                }
            }
        }
        return jumpArray[0] ? 1 : 0;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 1, 0, 5, 2);
        JumpGameArray lJumpGameArray = new JumpGameArray();
        System.out.println(lJumpGameArray.canJump(list));
    }
}
