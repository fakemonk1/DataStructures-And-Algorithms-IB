package greedy;

import java.util.Arrays;
import java.util.List;

/**
Problem: Given an array of integers, return the highest product possible by multiplying 3 numbers from the array

 Input:
 array of integers e.g {1, 2, 3}
 NOTE: Solution will fit in a 32-bit signed integer

 Example:
 [0, -1, 3, 100, 70, 50]
 => 70*50*100 = 350000

 Solution: After sorting, top 3 or lowest 3(in case of negatives) will be contributing to the max product

 */

public class HighestProduct {

    public int getHighestProduct(List<Integer> input) {
        input.sort(Integer::compareTo);
        int last = input.size() - 1;

        int type1 = input.get(last) * input.get(last - 1) * input.get(last - 2);
        int type2 = input.get(0) * input.get(1) * input.get(last);
        return Math.max(type1, type2);

    }

    public static void main(String[] args) {
        System.out.println(new HighestProduct().getHighestProduct(Arrays.asList(1, -4, 3, -6, 7, 0)));
    }
}
