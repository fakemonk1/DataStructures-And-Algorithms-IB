package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/roman-to-integer/
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.

 Read more details about roman numerals at Roman Numeric System

 Example :

 Input : "XIV"
 Return : 14
 Input : "XX"
 Output : 20
 */

public class RomanToInteger {
    public static int romanToInt(String a) {
        Map<String, Integer> map = getMap();
        int answer = 0;
        for (int i = 0; i < a.length(); i++) {
            StringBuilder roman = new StringBuilder("");
            char c = a.charAt(i);
            if ((c == 'I' || c == 'X' || c == 'C') && (i != a.length() - 1)) {

                char next = a.charAt(i + 1);
                roman.append(c);
                switch (String.valueOf(c)) {
                    case "I":
                        if (next == 'V' || next == 'X') {
                            roman.append(next);
                            i++;
                        }

                        break;

                    case "X":
                        if (next == 'L' || next == 'C') {
                            roman.append(next);
                            i++;
                        }
                        break;
                    case "C":
                        if (next == 'D' || next == 'M') {
                            roman.append(next);
                            i++;
                        }
                        break;
                }
            } else {
                roman = roman.append(c);
            }
            answer += map.get(roman.toString());
        }
        return answer;
    }

    public static Map<String, Integer> getMap() {
        Map<String, Integer> romanToNumberMap = new HashMap<>();
        romanToNumberMap.put("I", 1);
        romanToNumberMap.put("V", 5);
        romanToNumberMap.put("X", 10);
        romanToNumberMap.put("L", 50);
        romanToNumberMap.put("C", 100);
        romanToNumberMap.put("D", 500);
        romanToNumberMap.put("M", 1000);
        romanToNumberMap.put("IV", 4);
        romanToNumberMap.put("IX", 9);
        romanToNumberMap.put("XL", 40);
        romanToNumberMap.put("XC", 90);
        romanToNumberMap.put("CD", 400);
        romanToNumberMap.put("CM", 900);
        return romanToNumberMap;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MDCCCIV"));
    }

}

