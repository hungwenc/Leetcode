public class L344ReverseString {
//	public String reverseString(String s) {
//	  	String temp = "";
//	  	char[] ch = s.toCharArray();
//		for (int i = s.length()-1; i>=0 ;i--){
//			temp = temp + ch[i];
//		}
//		return temp;
//	}
//	Not pass
//	Note
//	Java String is immutable, so by "re += c[i];", you are creating a new String object each time. Creating objects costs time, but what is worse is that when there are too many small objects which are no longer used, garbage collector starts to work, and this slows down the program. I guess this is the reason that your program exceeded time limit.
//	Interesting theory, but I don't think that's it. I added String t = "" + i; to your loop, which creates a new string each iteration and does slow down your time from 4ms to 20ms, still well within the allowed time.

	
	
//    public String reverseString(String s) {
//        StringBuilder sb = new StringBuilder(s);
//        return sb.reverse().toString();
//    }
    public String reverseString(String s){
    	char[] word = s.toCharArray();
    	int i = 1;
    	int j = s.length()-1;
    	while(i<j){
    		char temp = word[i];
    		word[i] = word[j];
    		word[j] = temp;
    		i++;
    		j--;
    	}
    	return new String(word);
    }

    public static void main(String[] args) throws Exception {
//    	String[] input = new String[] {"a","b","c"};
    	L344ReverseString s = new L344ReverseString();
    	String input ="ABCDEFG";    
    	long time1 = System.nanoTime();
    	String ans = s.reverseString(input);
    	long time2 = System.nanoTime();
        long timeTaken = time2 - time1;  
        System.out.println("Time taken " + timeTaken + " ns");  
    	System.out.println(ans);
    	int a = 'a'^'a';
    	int b = a^'a';
    	System.out.println(a);
    	char m = (97);
    	System.out.println(m);    
    }
}