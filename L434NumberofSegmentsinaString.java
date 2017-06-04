/*L434. Number of Segments in a String
Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
Please note that the string does not contain any non-printable characters.
Example:
Input: "Hello, my name is John"
Output: 5
 */
public class L434NumberofSegmentsinaString {
	public int countSegments(String s) {
	    int res = 0;
	    for(int i = 0; i<s.length(); i++){
	        if(s.charAt(i) != ' ' && (i==0 || s.charAt(i-1)==' ')){ //i==0 put first since we use '||' short circuit
	            res ++ ;
	        }
	    }
	    return res;
	}
}
/* sol2 
use regular expersion
public class Solution {
    public int countSegments(String s) {
        s=s.trim();
        if(s.length()==0){
            return 0;
        }
        return s.split("\\s+").length;
    }    
}
*/
