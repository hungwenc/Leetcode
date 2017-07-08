/*412. Fizz Buzz
Write a program that outputs the string representation of numbers from 1 to n.
But for multiples of three it should output “Fizz” instead of the number and 
for the multiples of five output “Buzz”. 
For numbers which are multiples of both three and five output “FizzBuzz”.
*/
public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new LinkedList<>(); 
        if(n < 1) return res;
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 ==0){ // 15 mult
                res.add("FizzBuzz");
            }else if( i % 3 == 0 && i % 5 != 0){ // 3 mult
                res.add("Fizz");
            }else if( i % 3 != 0 && i % 5 == 0){ // 5 mult
                res.add("Buzz");
            }else{
                res.add(i + "");
            }
        }
        return res;
    }
}

/*Java 4ms solution , Not using "%" operation
public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<String>(n);
        for(int i=1,fizz=0,buzz=0;i<=n ;i++){
            fizz++;
            buzz++;
            if(fizz==3 && buzz==5){
                ret.add("FizzBuzz");
                fizz=0;
                buzz=0;
            }else if(fizz==3){
                ret.add("Fizz");
                fizz=0;
            }else if(buzz==5){
                ret.add("Buzz");
                buzz=0;
            }else{
                ret.add(String.valueOf(i));
            }
        } 
        return ret;
    }
}
*/
