package graphs;

import java.util.List;

/**
 * https://www.interviewbit.com/problems/black-shapes/
 *
 * Given N * M field of O's and X's, where O=white, X=black
 Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

 Example:

 OOOXOOO
 OOXXOXO
 OXOOOXO

 answer is 3 shapes are  :
 (i)    X
 X X
 (ii)
 X
 (iii)
 X
 X
 Note that we are looking for connected shapes here.

 For example,

 XXX
 XXX
 XXX
 is just one single connected black shape.

 */
public class BlackShapes {
    int[][] marked;

    public int black(List<String> a) {
        if (a.isEmpty())
            return 0;
        char[][] input = getInput(a);
        marked = new int[input.length][input[0].length];

        int count = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(0).length(); j++) {
                if (a.get(i).charAt(j) == 'X' && marked[i][j] != 1) {
                    count++;
                    getDFS(i, j, input);
                }
            }
        }
        return count;
    }

    public void getDFS(int i, int j, char[][] input) {
        if (marked[i][j] != 1) {
            marked[i][j] = 1;

            if (isDownX(i, j, input)) {
                getDFS(i + 1, j, input);
            }
            if (isUpX(i, j, input)) {
                getDFS(i - 1, j, input);
            }
            if (isLeftX(i, j, input)) {
                getDFS(i, j - 1, input);
            }
            if (isRightX(i, j, input)) {
                getDFS(i, j + 1, input);
            }
        }
    }

    public boolean isRightX(int i, int j, char[][] input) {
        if (j < input[0].length - 1 && input[i][j + 1] == 'X') {
            return true;
        }
        return false;
    }

    public boolean isLeftX(int i, int j, char[][] input) {
        if (j != 0 && input[i][j - 1] == 'X') {
            return true;
        }
        return false;
    }

    public boolean isUpX(int i, int j, char[][] input) {
        if (i != 0 && input[i - 1][j] == 'X') {
            return true;
        }
        return false;
    }

    public boolean isDownX(int i, int j, char[][] input) {
        if (i != input.length - 1 && input[i + 1][j] == 'X') {
            return true;
        }
        return false;
    }

    public char[][] getInput(List<String> a) {
        char[][] input = new char[a.size()][a.get(0).length()];
        for (int i = 0; i < a.size(); i++) {
            input[i] = a.get(i).toCharArray();
        }
        return input;
    }


}