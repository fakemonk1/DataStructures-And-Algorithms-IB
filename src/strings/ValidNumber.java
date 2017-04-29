package strings;

/**
 * https://www.interviewbit.com/problems/valid-number/
 * Validate if a given string is numeric.

 Examples:

 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true
 Return 0 / 1 ( 0 for false, 1 for true ) for this problem

 Clarify the question using “See Expected Output”

 Is 1u ( which may be a representation for unsigned integers valid?
 For this problem, no.
 Is 0.1e10 valid?
 Yes
 -01.1e-10?
 Yes
 Hexadecimal numbers like 0xFF?
 Not for the purpose of this problem
 3. (. not followed by a digit)?
 No
 Can exponent have decimal numbers? 3e0.1?
 Not for this problem.
 Is 1f ( floating point number with f as prefix ) valid?
 Not for this problem.
 How about 1000LL or 1000L ( C++ representation for long and long long numbers )?
 Not for this problem.
 How about integers preceded by 00 or 0? like 008?
 Yes for this problem
 */
public class ValidNumber {

    public int isNumber(final String b) {
        String a = b.trim();

        if(a.length()==0)
            return 0;
        boolean isExponential = false;
        int countDots = 0;
        int countMinus = 0;
        for (int i = 0; i < a.length(); i++) {

            //check dots
            if (a.charAt(i) == '.') {
                if (++countDots > 1) {
                    return 0;
                }
            }

            if (a.charAt(i) == '-') {
                if (++countMinus > 2) {
                    return 0;
                }
            }

            if (a.charAt(i) == ' ') {
                return 0;
            } else if (a.charAt(i) == 'e') {
                //mark to check for exponential case
                isExponential = true;
            } else if (!checkForNumericDigit(a.charAt(i))) {
                return 0;
            }
        }
        if (isExponential) {
            return checkForExponential(a) == true ? 1 : 0;
        }
        if( !isExponential && countMinus > 1){
            return 0;
        }

        if(!checkForDotPlacement(a)){
            return 0;
        }
        return 1;
    }

    public boolean checkForNumericDigit(char c) {
        return ('0' <= c && c <= '9') || c == 'e' || c == '.' || c=='-';
    }


    public boolean checkForExponential(String str) {
        //no multiplier case
        if (str.charAt(0) == 'e' || str.charAt(str.length() - 1) == 'e') {
            return false;
        }

        String[] es = str.split("e");
        if (es.length != 2) {
            return false;
        }

        //second part contains a dot
        if (es[1].contains(".")) {
            return false;
        }

        //TODO check for negative in first and second array
        if( !(checkForValidNEgative(es[0]) && checkForValidNEgative(es[1]))){
            return false;
        }

        if(!(checkForDotPlacement(es[0]) && checkForDotPlacement(es[1]))){
            return false;
        }
        return true;
    }

    public boolean checkForValidNEgative(String str){
        String[] split = str.split("-");
        if(split.length > 2){
            return  false;
        }else if(split.length == 2){
            return split[0].isEmpty();
        }
        return true;
    }

    boolean checkForDotPlacement(String str){
        String[] split = str.split(".");
        if(split.length >2){
            return false;
        }else if(str.charAt(str.length()-1) == '.'){
             return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new ValidNumber().isNumber("       "));
    }

}
