/*L8. String to Integer (atoi)
Implement atoi to convert a string to an integer.
Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

(hint) Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/
class Solution {
    public int myAtoi(String str) {
        /*example
          12y5 -> 12
          15.4 -> 15
          14^100 -> 14
        */
        if(str == null || str.length() == 0 ) return 0; 
        
        // discards as many whitespace characters 
        str = str.trim();
        int sign = 1;
        int index = 0;
        // initial plus or minus sign or no sign
        if(Character.isDigit(str.charAt(index))){
            sign = +1;
            index = 0;
        }else if(str.charAt(index) == '+'){
            sign = +1;
            index = 1;
        }else if(str.charAt(index) == '-'){
            sign = -1;
            index = 1;
        }else{
            return 0;
        }
        
        long res = 0; // avoid overflow
        while(index < str.length()){
            if(Character.isDigit(str.charAt(index))){
                res = res * 10 + (str.charAt(index) - '0');
                index++;
                if(res*sign >= Integer.MAX_VALUE){
                    return Integer.MAX_VALUE; 
                }
                if(res*sign <= Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }else{
                break;
            }
        }
        res = res * sign;
        return (int)res;
    }
}
