/*L150. Evaluate Reverse Polish Notation
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another expression.
Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/
// postfix -> evaluation
// String to integer: Integer.parseInt(your_str)
// integer to String: Integer.toString(your_int)
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null) return 0;
        Stack<String> stack = new Stack<>();
        String op1 = "";
        String op2 = "";
        int tmp = 0;
        for(String s : tokens){
            if(s.equals("+")){
                op2 = stack.pop();
                op1 = stack.pop();
                tmp = Integer.valueOf(op1) + Integer.valueOf(op2);
                stack.push(Integer.toString(tmp));
            }else if(s.equals("-")){
                op2 = stack.pop();
                op1 = stack.pop();
                tmp = Integer.valueOf(op1) - Integer.valueOf(op2);
                stack.push(Integer.toString(tmp));
            }else if(s.equals("*")){
                op2 = stack.pop();
                op1 = stack.pop();
                tmp = Integer.valueOf(op1) * Integer.valueOf(op2);
                stack.push(Integer.toString(tmp));
            }else if(s.equals("/")){
                op2 = stack.pop();
                op1 = stack.pop();
                tmp = Integer.valueOf(op1) / Integer.valueOf(op2);
                stack.push(Integer.toString(tmp));
            }else{
                stack.push(s);
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
