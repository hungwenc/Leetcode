import java.util.*;

//118. Pascal's Triangle
/*
 *Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 */

public class L118PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
    	// List is jut an interface
        List<List<Integer>> outer = new ArrayList<List<Integer>>();
        for(int i = 0; i < numRows; i++){
            List<Integer> inner = new ArrayList<Integer>();
            if(i==0){
                inner.add(1);
            }else if(i==1){
                inner.add(1);
                inner.add(1);
            }else{
                inner.add(1);
                List<Integer> temp = outer.get(i-1);
                for(int j = 0; j < temp.size()-1; j++){
                    inner.add(temp.get(j)+temp.get(j+1));
                }
                inner.add(1);
            }
            outer.add(inner);
        }
        return outer;
    }
}
