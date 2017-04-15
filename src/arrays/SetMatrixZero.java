package arrays;

import java.util.ArrayList;

/**
 * Given an m x n matrix of 0s and 1s, if an element is 0,
 * set its entire row and column to 0.Do it in place.
 *
 * P.S. This can be further optimized by using first row and first column of the input matrix
 * in place of the auxiliary arrays row[] and col[]
 */
public class SetMatrixZero {

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        boolean[] row = new boolean[a.size()];
        boolean[] column = new boolean[a.get(0).size()];

        // Store the row and column index with value 0
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(0).size(); j++) {
                if (a.get(i).get(j) == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // Nullify rows
        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                nullifyRow(a, i);
            }
        }

        // Nullify columns
        for (int j = 0; j < column.length; j++) {
            if (column[j]) {
                nullifyColumn(a, j);
            }
        }
    }

    public static void nullifyRow(ArrayList<ArrayList<Integer>> matrix, int row) {
        for (int j = 0; j < matrix.get(0).size(); j++) {
            matrix.get(row).set(j, 0);
        }
    }

    public static void nullifyColumn(ArrayList<ArrayList<Integer>> matrix, int col) {
        for (int i = 0; i < matrix.size(); i++) {
            matrix.get(i).set(col, 0);
        }
    }
}