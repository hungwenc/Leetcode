import java.util.*;
/*349. Intersection of Two Arrays
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
Subscribe to see which companies asked this question.

Show Tags
Show Similar Problems

*/
public class L349IntersectionofTwoArrays {
	public int[] intersection(int[] num1, int[] num2){
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> intersection = new HashSet<Integer>();
		for(int each : num1){
			set1.add(each);
		}
		System.out.println("size: "+ set1.size());
		for(int each : num2){
			if(set1.contains(each)){
				intersection.add(each);
			}
		}
		
		int[] result = new int[intersection.size()];
		int i = 0;
		for(Integer each : intersection){
			result[i] = each;
			i++;
		}
		return result;
	}
    
    public static void main(String[] args) throws Exception {
    	L349IntersectionofTwoArrays s = new L349IntersectionofTwoArrays();
    	int[] num1 = {1,2,4,6,7,8,8};  
    	int[] num2 = {1,8,8};  
    	long time1 = System.nanoTime();
    	int[] res = s.intersection(num1, num2);
    	long time2 = System.nanoTime();
        long timeTaken = time2 - time1;  
        System.out.println("Time taken " + timeTaken + " ns");  
    	for(int each: res){
    		System.out.println(each);
    	}
    }
}
