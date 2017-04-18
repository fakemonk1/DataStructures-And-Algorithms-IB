package arrays;

import java.util.List;

/**
 * this is the general algo for any k value, based on the Tetris algorithm
 */

public class N3RepeatNumber {


    public int findElement(Integer[] arrA, int k) {
        Elements[] elements = new Elements[k - 1];

        //initialize at the start TODO: can be omitted?
        for (int j = 0; j < elements.length; j++) {
            elements[j] = new Elements(0, 0);
        }

        for (int i = 0; i < arrA.length; i++) {
            int index = find(elements, arrA[i]);
            if (index >= 0) {
                // means element found in Elements array
                // just increase its count
                elements[index].count++;
            } else {
                addToArray(elements, arrA[i]);
            }
        }


        // now check if any of the elements in the Elements array appears
        // more than n/k times
        for (int i = 0; i < elements.length; i++) {
            int cnt = 0;
            for (int j = 0; j < arrA.length; j++) {
                if (arrA[j] == elements[i].element) {
                    cnt++;
                }
            }
            if (cnt > (arrA.length / k)) {
                return elements[i].element;
                /*System.out.println(elements[i].element + " appears more than n/"
                        + k + " times, Actual count is " + cnt);*/
            }
        }
        return -1;
    }

    public void addToArray(Elements[] elements, int x) {
        // check is array is full or not
        for (int j = 0; j < elements.length; j++) {
            if (elements[j].count == 0) {// find the empty place and add it
                elements[j].element = x;
                elements[j].count = 1;
                return;
            }
        }
        // if we have reached here means array is full reduce the counter of every element and ignore this element
        for (int j = 0; j < elements.length; j++) {
            elements[j].count--;
        }
    }

    public int find(Elements[] emts, int x) {

        for (int j = 0; j < emts.length; j++) {
            if (emts[j].element == x) {
                return j;
            }
        }
        return -1;
    }

    public int repeatedNumber(final List<Integer> inputList) {
        if(inputList.size() < 3){
            return -1;
        }
        Integer[] stockArr = new Integer[inputList.size()];
        Integer[] input = inputList.toArray(stockArr);
        return findElement(input, 3);
    }

    public static void main(String[] args) {
        int[] arrA = {3, 1, 2, 2, 1, 2, 3, 3 };
        //new N3RepeatNumber().findElement(arrA, 4);
        System.out.println("Any number that appears more than n/3 times");
    }
    static class Elements {
        int element;
        int count;

        public Elements(int element, int count) {
            this.element = element;
            this.count = count;
        }
    }


}
