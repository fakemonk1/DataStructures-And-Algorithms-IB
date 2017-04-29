package dynamicprogramming;

import java.util.*;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given

 s = "myinterviewtrainer",
 dict = ["trainer", "my", "interview"].
 Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as "my interview trainer".

 Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */

public class WordBreak {

    // O(string length * dict size). if the size of the dictionary is very large, the time is bad
    public int wordBreak1(String s, ArrayList<String> B) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true;   //Because we need initial state


        Set<String> dict = new HashSet<>(B);

        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i])
                continue;

            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;

                if(t[end]) continue;

                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }

        return t[s.length()]?1:0;
    }

    //O(n^2) time (n is the length of the string)
    public boolean wordBreak2(String s, List<String> wordDict) {
        int[] pos = new int[s.length()+1];

        Arrays.fill(pos, -1);

        pos[0]=0;

        for(int i=0; i<s.length(); i++){
            if(pos[i]!=-1){
                for(int j=i+1; j<=s.length(); j++){
                    String sub = s.substring(i, j);
                    System.out.println("testing for:  " + sub);
                    if(wordDict.contains(sub)){
                        pos[j]=i;
                    }
                }
            }
        }

        return pos[s.length()]!=-1;
    }

    public static void main(String[] args) {

        WordBreak mWordBreak = new WordBreak();
        String str = "iamace";
        ArrayList<String> list = new ArrayList<>(Arrays.asList( "i", "am", "a", "ace"));
        System.out.println(mWordBreak.wordBreak2(str, list));
    }

}
