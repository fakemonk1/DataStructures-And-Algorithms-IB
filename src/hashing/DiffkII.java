package hashing;

import java.util.HashMap;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/diffk-ii/
 *
 * Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

 Example :

 Input :

 A : [1 5 3]
 k : 2
 Output : 1
 as 3 - 1 = 2

 Return 0 / 1 for this problem.
 */

public class DiffkII {
    public HashMap<Integer, Integer> map = new HashMap<>();

    public int diffPossible(final List<Integer> a, int b) {
        if(a.size() <= 1 )
            return 0;
        for (int i = 0; i < a.size(); i++) {
            map.put(a.get(i)-b, i);
        }

        for (int i = 0; i < a.size(); i++) {
            if(map.containsKey(a.get(i)) && map.get(a.get(i)) != i ){
                return 1;
            }
        }

        return 0;
    }
}
