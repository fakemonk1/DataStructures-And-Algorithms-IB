package strings;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/pretty-json/
 * Pretty print a json object using proper indentation.

 Every inner brace should increase one indentation to the following lines.
 Every close brace should decrease one indentation to the same line and the following lines.
 The indents can be increased with an additional ‘\t’
 Example 1:

 [] and {} are only acceptable braces in this case.

 Assume for this problem that space characters can be done away with.

 Your solution should return a list of strings, where each entry corresponds to a single line. The strings should not have “\n” character in them.
 * {A:"B",C:{D:"E",F:{G:"H",I:"J"}}}
 * ["foo", {"bar":["baz",null,1.0,2]}]
 */
public class PrettyJSON {
    ArrayList<String> solution = new ArrayList<>();

    public ArrayList<String> prettyJSON(String a) {
        return beautiFy(a, 0);
    }


    public ArrayList<String> beautiFy(String a, int currentIndentation) {

        //todo use stringBuffer
        String strToAppend = "";
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);

            if (c == '{' || c == '[') {
                if(!strToAppend.trim().equals("")){
                    solution.add(appendIndent(strToAppend, currentIndentation));
                    strToAppend = "";
                }
                solution.add(appendIndent("" + c, currentIndentation));
                currentIndentation++;
            } else if (c == '}' || c == ']') {
                if(!strToAppend.trim().equals("")){
                    solution.add(appendIndent(strToAppend, currentIndentation));
                    strToAppend = "";
                }
                currentIndentation--;
                solution.add(appendIndent("" + c, currentIndentation));

            } else {
                strToAppend = strToAppend.concat("" + c);
                if (c == ',') {
                    if(strToAppend.equals(",")){
                        //set at last location
                        String concat = solution.get(solution.size() - 1).concat(",");
                        solution.set(solution.size()-1,concat );
                        strToAppend = "";
                    }else{

                        solution.add(appendIndent(strToAppend, currentIndentation));
                        strToAppend = "";
                    }
                }
            }
        }
        return solution;
    }

    public String appendIndent(String str, int indent) {
        StringBuilder sb = new StringBuilder("");
        int i = 1;
        while (i <= indent) {
            sb.append('\t');
            i++;
        }
        sb.append(str);
        return sb.toString();
    }

    static void printSolution(ArrayList<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC.normalized());
        System.out.println(now);
        //ArrayList<String> strings = new PrettyJSON().prettyJSON("{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}");
        //printSolution(strings);

    }
}

