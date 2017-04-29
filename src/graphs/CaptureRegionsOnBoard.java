package graphs;
import java.util.ArrayList;

/**
 *
 *
 https://www.interviewbit.com/problems/capture-regions-on-board/

 *Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,

 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X

 Solution:
 1. replace all initial Zeros with '-'
 2. Do BFS on the all dashes present on the matrix border, and make all of them as 0. They are the ones which will retain their shapes after capturing
 3. Replace all Dashes in the matrix to 0

 */

public class CaptureRegionsOnBoard {
    public static char O = 'O';
    public static char DASH = '-';

    int[][] discovered;

    public void solve(ArrayList<ArrayList<Character>> a) {
        if (a.isEmpty())
            return;
        Character[][] input = new Character[a.size()][a.get(0).size()];
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(0).size(); j++) {
                input[i][j]  = a.get(i).get(j);
            }
        }

        replace(input);
        formatAnswer(input, a);
    }

    public void replace(Character[][] input) {
        discovered = new int[input.length][input[0].length];

        //1. replace all initial Zeros with '-'
        fillWithDash(input);
        //2. go through the edges and make all connected '-' as O
        doBFSOnDashesOnEdges(input);
        //3. replace all Dashes in the matrix to 0
        replaceAllDash(input);

        //return input;
    }

    private void doBFSOnDashesOnEdges(Character[][] input) {

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                //work only on the edges
                if (i == 0 || i == input.length - 1  || j == 0 || j == input[i].length - 1) {
                    if (input[i][j] == DASH) {
                        BFSReplaceAllConnectedDashesUtil(i, j, input);
                    }
                }
            }
        }
    }


    public void BFSReplaceAllConnectedDashesUtil(int x, int y, Character[][] input) {
        if (isOutside(x, y, input)) {
            return;
        } else if (input[x][y] != DASH) {
            return;
        } else {
            if (discovered[x][y] != 1) {
                discovered[x][y] = 1;
                replace(x, y, input);
                BFSReplaceAllConnectedDashesUtil(x + 1, y, input);
                BFSReplaceAllConnectedDashesUtil(x - 1, y, input);
                BFSReplaceAllConnectedDashesUtil(x, y + 1, input);
                BFSReplaceAllConnectedDashesUtil(x, y - 1, input);
            }
        }
    }

    public  boolean isOutside(int x, int y, Character[][] input) {
        return x > input.length - 1 || y > input[0].length - 1 || x < 0 || y < 0;
    }

    public void replace(int x, int y, Character[][] input) {
        input[x][y] = O;
    }


    public void fillWithDash(Character[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == O)
                    input[i][j] = DASH;
            }
        }

    }

    public void replaceAllDash(Character[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == DASH)
                    input[i][j] = 'X';
            }
        }

    }

    public void formatAnswer(Character[][] input, ArrayList<ArrayList<Character>> a){

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                a.get(i).set(j,input[i][j]);
            }
        }
    }
}

