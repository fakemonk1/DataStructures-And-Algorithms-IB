package dynamicprogramming;

/**
 * https://www.interviewbit.com/problems/edit-distance/
 * <p>
 * Given two words A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)
 * <p>
 * You have the following 3 operations permitted on a word:
 * <p>
 * Insert a character
 * Delete a character
 * Replace a character
 * Example :
 * edit distance between
 * "Anshuman" and "Antihuman" is 2.
 * <p>
 * Operation 1: Replace s with t.
 * Operation 2: Insert i.
 */
public class EditDistance {

    int[][] store;

    public int stepsInEditing(String a, String b, int end1, int end2) {

        if (end1 < 0 || end2 < 0)
            return 0;
        if (end1 == 0) {
            return end2;
        }
        if (end2 == 0) {
            return end1;
        } else if (a.charAt(end1 - 1) == b.charAt(end2 - 1)) {
            return stepsInEditing(a, b, end1 - 1, end2 - 1);
        } else {
            if (store[end1][end2] != -1)
                return store[end1][end2];
            int answer = 1 + getMinimum(
                    //insert
                    stepsInEditing(a, b, end1, end2 - 1),
                    //remove
                    stepsInEditing(a, b, end1 - 1, end2),
                    //replace
                    stepsInEditing(a, b, end1 - 1, end2 - 1)
            );
            store[end1][end2] = answer;
            return answer;
        }

    }


    public int getMinimum(int x, int y, int z) {
        if (x < y && x < z) return x;
        if (y < x && y < z) return y;
        else return z;
    }

    public int minDistance(String a, String b) {
        store = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                store[i][j] = -1;
            }
        }
        return stepsInEditing(a, b, a.length(), b.length());
    }

    public static void main(String[] args) {
        //System.out.println(new EditDistance().getMinimum(2,1,5));
        System.out.println(new EditDistance().minDistance("sunday", "saturday"));
    }
}
