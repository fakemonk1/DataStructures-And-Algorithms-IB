package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * . . . . x . . x x . . . x . .
 * 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4
 * <p>
 * <p>
 * median  = {4, 7, 8, 2}
 */
public class Seats {

    public static final Character FULL_SEAT = 'x';
    public static final int MOD = 10000003;

    public int getMinHops(List<Character> seats) {
        if (seats.isEmpty())
            return 0;
        else if(!seats.contains(FULL_SEAT)){
            return 0;
        }
        //get median element
        int median = getMedianIndex(seats);

        int leftHops = getLeftHops(seats, 0, median - 1, median);
        int rightHops = getRightHops(seats, median + 1, seats.size() - 1, median);
        return  (leftHops + rightHops) % MOD;

    }

    public int getMedianIndex(List<Character> seats) {


        List<Integer> medianList = new ArrayList<>();
        for (int i = 0; i < seats.size(); i++) {
            if (isFull(seats, i))
                medianList.add(i);
        }
        return medianList.get(medianList.size() / 2);
    }

    public int getLeftHops(List<Character> seats, int start, int end, int median) {
        int ans = 0;
        int empty = isFull(seats, median) ? median - 1 : median;

        for (int i = median - 1; i >= 0; --i) {
            if (isFull(seats, i)) {
                ans = (ans % MOD + getHops(empty, i)) % MOD;
                empty--;
            }
        }
        return ans;
    }

    public int getRightHops(List<Character> seats, int start, int end, int median) {
        int ans = 0;
        int empty = median + 1;

        for (int i = median + 1; i <= end; ++i) {
            if (seats.get(i) == 'x') {
                ans = ((ans % MOD) + (i) - empty) % MOD;
                empty++;
            }
        }
        return ans;
    }

    public int seats(String a) {
        List<Character> seats = new ArrayList<>();
        for (Character ch : a.toCharArray()) {
            if (ch.equals('.') || ch.equals('x'))
                seats.add(ch);
        }
        return getMinHops(seats);
    }

    public int getHops(int int1, int int2) {
        return Math.abs(int1 - int2);
    }

    public boolean isFull(List<Character> seats, int index) {
        return seats.get(index).equals(FULL_SEAT);
    }

    public static void main(String[] args) {
         //System.out.println(new Seats().getMinHops(asList('.', '.', '.', '.', 'x', '.', '.', 'x', 'x', '.', '.', '.', 'x', '.', '.')));
        System.out.println(new Seats().seats(("xxxx")));
    }
}
