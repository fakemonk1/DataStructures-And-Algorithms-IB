package arrays;

import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal’s triangle.
   Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1
 */
public class PascalTriangleRows {

    public class Solution {
        public ArrayList<ArrayList<Integer>> generate(int A) {
            int numRows = A;
            ArrayList<ArrayList<Integer>> answers = new ArrayList<>();

            if (A == 0)
                return answers;

            answers.add(new ArrayList<>());
            answers.get(0).add(1);

            for (int i = 1; i < numRows; i++) {

                answers.add(new ArrayList<>());

                answers.get(i).add(1);

                for (int j = 0; j < i - 1; j++) {
                    int num = answers.get(i - 1).get(j) + answers.get(i - 1).get(j + 1);
                    answers.get(i).add(num);
                }
                answers.get(i).add(1);
            }
            return answers;
        }
    }
}
