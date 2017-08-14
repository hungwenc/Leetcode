/*L657. Judge Route Circle
Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false
*/
public class Solution {
    public boolean judgeCircle(String moves) {
        int ver = 0;
        int hor = 0;
        char[] sarr = moves.toCharArray();
        for(char c: sarr){
            if(c == 'U'){
                ver++;
            }else if(c == 'D'){
                ver--;
            }else if(c == 'L'){
                hor--;
            }else if(c == 'R'){
                hor++;
            }
        }
        return (hor == 0 && ver == 0);
    }
}
