package greedy;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.
 You may assume that the array is non-empty and the majority element always exist in the array.
 Example :
 Input : [2, 1, 2]
 Return  : 2 which occurs 2 times which is greater than 3/2.
 * Created by Ashish Gupta on 14/03/17.
 */
public class MajorityElement {

    public Hashtable<Integer, Integer> map = new Hashtable<>();

    public int getMajorityElement(List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            if (map.containsKey(input.get(i))) {
                map.put(input.get(i), map.get(input.get(i)) + 1);
                if(map.get(input.get(i)) + 1 > input.size()/2)
                    break;
            }else{
                map.put(input.get(i), 1);
            }
        }
        int maxCountTillNow = Integer.MIN_VALUE;
        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCountTillNow) {
                maxCountTillNow = entry.getValue();
                maxValue = entry.getKey();
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().getMajorityElement(Arrays.asList(1, 3, 3, 1, 2)));
    }

}
