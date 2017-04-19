package hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/valid-sudoku/
 *
 * Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

 The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.

 */
public class ValidSudoku {

    public int isValidSudoku(final List<String> a) {
        char[][] array = fillMatrix(a);
        return (checkAllRow(a) && checkColumn(array) && checkBlocks(array)) ? 1 : 0;
    }

    public char[][] fillMatrix(final List<String> a) {
        char[][] array = new char[9][9];
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).length(); j++) {
                array[i][j] = a.get(i).charAt(j);
            }
        }
        return array;
    }

    public boolean checkAllRow(List<String> a) {
        for (String row : a) {
            HashSet<Character> rowValues = new HashSet<>();
            for (Character ch : row.toCharArray()) {
                if (!ch.equals('.')) {
                    if (!rowValues.add(ch)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean checkColumn(char[][] array) {
        for (int j = 0; j < array[0].length; j++) {
            HashSet<Character> colValues = new HashSet<>();
            for (int ii = 0; ii < array.length; ii++) {
                if (!(array[ii][j] == '.')) {
                    if (!colValues.add(array[ii][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean checkBlocks(char[][] array) {

        int colStart = 0;
        int colEnd = 2;

        while (colEnd < array[0].length) {
            int rowStart = 0;
            int rowEnd = 2;
            while (rowEnd < array.length) {
                if (!checkBlock(array, rowStart, rowEnd, colStart, colEnd)) {
                    return false;
                }
                rowStart = rowStart + 3;
                rowEnd = rowEnd + 3;
            }
            colStart = colStart + 3;
            colEnd = colEnd + 3;
        }
        return true;
    }

    public boolean checkBlock(char[][] array, int rowStart, int rowEnd, int colStart, int colEnd) {
        HashSet<Character> colValues = new HashSet<>();
        for (int row = rowStart; row <= rowEnd; row++) {
            for (int col = colStart; col <= colEnd; col++) {
                char ch = array[row][col];
                if ((ch) != '.') {
                    if (!colValues.add(ch)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println( new ValidSudoku().isValidSudoku(Arrays.asList( "....5..1.", ".4.3.....", ".....3..1", "8......2.", "..2.7....", ".15...6..", ".....2...", ".2.9....6", "..4......" )));
}

}
