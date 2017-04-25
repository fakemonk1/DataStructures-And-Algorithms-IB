package dynamicprogramming;

import java.util.HashMap;

/**
 * https://www.interviewbit.com/problems/ways-to-decode/
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 Example :

 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.

 */
public class WaysToDecode {
    public HashMap<String, Integer> map = new HashMap<>();

    public int numDeco(String a) {
        int i = numDecodings(a);
        return i;

    }

    public int numDecodings(String a) {

        if (a.length() == 1) {
            if (!a.equals("0")) {
                map.put(a, 1);
                return 1;
            } else {
                map.put(a, 0);
                return 0;
            }
        } else if (a.length() == 2) {
            int i = Integer.parseInt(a);
            if (i <= 26 && i >= 10) {
                if (i == 10 || i ==20) {
                    map.put(a, 1);
                    return 1;
                }
                map.put(a, 2);
                return 2;
            } else if (getLast1(a).equals("0")) {
                return 0;
            } else if (i > 26) {
                map.put(a, 1);
                return 1;
            } else {
                map.put(a, 0);
                return 0;
            }

        } else if (!map.containsKey(a)) {
            int ans1 = 0;
            int ans2 = 0;
            if (!getLast1(a).equals("0")) {
                ans1 = numDecodings(removeLast1(a));
            }
            int last2Int = Integer.parseInt(getLast2(a));
            if (last2Int >= 10 && last2Int <= 26) {
                ans2 = numDecodings(removeLast2(a));
            } else {
                ans2 = 0;
            }
            int ans = ans1 + ans2;
            map.put(a, ans);
        }
        return map.get(a);
    }

    public String getLast1(String a) {
        return a.substring(a.length() - 1, a.length());
    }

    public String removeLast1(String a) {
        return a.substring(0, a.length() - 1);
    }

    public String removeLast2(String a) {
        return a.substring(0, a.length() - 2);
    }

    public String getLast2(String a) {
        return a.substring(a.length() - 2, a.length());
    }

    public static void main(String[] args) {
        // System.out.println((int) 'A');
        int i = new WaysToDecode().numDeco("0799733");
        System.out.println(i);
    }

}
