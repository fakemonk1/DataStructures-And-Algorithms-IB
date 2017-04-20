package hashing;

import java.util.Hashtable;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/longest-substring-without-repeat/
 * <p>
 * Given a string,
 * find the length of the longest substring without repeating characters.
 * <p>
 * Example:
 * <p>
 * The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * <p>
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * <p>
 * Solution: start traversing the list, if the substring is unique, increase the maxTillNow,
 * if you see that this char has there been in past, initilize the start to the next of the previous occurance
 */

public class LongestSubstringWithoutRepeat {

    public int getMaxSubstringSize(String str) throws InterruptedException {
        if (str.length() <= 1) {
            return str.length();
        }
        int start = 0;
        int maxTillNow = 0;
        Map<Character, Integer> map = new Hashtable();

        for (int i = 0; i < str.length(); i++) {
            final char ch = str.charAt(i);
            if (map.containsKey(ch) && map.get(ch) >= start) {
                start = map.get(ch) + 1;
            }
            map.put(ch, i);
            maxTillNow = Math.max(maxTillNow, i - start + 1);
        }

        return maxTillNow;

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new LongestSubstringWithoutRepeat().getMaxSubstringSize("abaxycfxf"));
        //System.out.println(new LongestSubstringWithoutRepeat().getMaxSubstringSize("abcabcbb"));
    }

}
