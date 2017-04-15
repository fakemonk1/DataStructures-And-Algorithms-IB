package arrays;

import java.util.ArrayList;

/**
 */
public class KthRowOfPascalsTriangle{

    public ArrayList<Integer> getRow(int A) {

        ArrayList<Integer> res = new ArrayList<>();

        res.add(1);

        for (int k = 0; k < A; k++) {
            int val;
            int last = 0;
            for (int i = 0; i < k + 1; i++) {
                val = res.get(i);
                if (i - 1 >= 0)
                    val += last;
                last = res.get(i);
                res.set(i, val);
            }

            res.add(res.get(0));
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(new KthRowOfPascalsTriangle().getRow(7));
    }
}
