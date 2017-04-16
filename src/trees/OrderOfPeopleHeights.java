package trees;

import java.util.*;

/**
 * You are given the following :
 * <p>
 * A positive number N
 * Heights : A list of heights of N persons standing in a queue
 * Infronts : A list of numbers corresponding to each person (P) that gives the number of persons who are taller than P and standing in front of P
 * You need to return list of actual order of persons’s height
 * Consider that heights will be unique
 * Example
 * Input :
 * Heights: 5 3 2 6 1 4
 * InFronts: 0 1 2 0 3 2
 * Output :
 * actual order is: 5 3 2 1 6 4
 * So, you can see that for the person with height 5, there is no one taller than him who is in front of him, and hence Infronts has 0 for him.
 * <p>
 * For person with height 3, there is 1 person ( Height : 5 ) in front of him who is taller than him.
 * <p>
 * You can do similar inference for other people in the list.
 */

public class OrderOfPeopleHeights {
    Integer[] solution;

    public ArrayList<Integer> order(List<Integer> heights, List<Integer> infronts) {

        solution = new Integer[heights.size()];

        //Map for each height, how many inFronts are there
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < heights.size(); i++) {
            map.put(heights.get(i), infronts.get(i));
        }

        ArrayList<Integer> sortedHeight = new ArrayList<>(heights);
        Collections.sort(sortedHeight);

        for (int i = 0; i < sortedHeight.size(); i++) {
            int height = sortedHeight.get(i);
            int infront = map.get(height);
            put(height, infront, heights.size());
        }

        return new ArrayList<Integer>(Arrays.asList(solution));
    }

    public void put(int height, int infront, int size) {
        int counter = -1;
        for (int i = 0; i < size; i++) {
            if (solution[i] == null) {
                counter++;
            }
            if (counter == infront) {
                solution[i] = height;
                break;
            }
        }
    }
}
