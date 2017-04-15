package arrays;

import java.util.*;
import java.util.Set;

/**
 * Given a read only array of n + 1 integers between 1 and n,
 * find one number that repeats in linear time using
 * less than O(n) space and traversing the stream sequentially O(1) times.
 */

public class FindDuplicateInArray {
        // DO NOT MODIFY THE LIST
        public int repeatedNumber(final List<Integer> a) {
            Set<Integer> set = new HashSet<>();
            for (int i : a) {
                boolean add = set.add(i);
                if (add == false) {
                    return i;
                }
            }
            return -1;
        }
}
