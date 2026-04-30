class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].matches("-?\\d+")){
                stack.push(Integer.parseInt(tokens[i]));
                continue;
            }
            Character op = tokens[i].charAt(0);
            int n1 = stack.pop();
            int n2 = stack.pop();
            if(op=='+'){
                stack.push(n2+n1);
            }
            else if(op=='-'){
                stack.push(n2-n1);
            }
            else if(op=='*'){
                stack.push(n2*n1);
            }
            else if(op=='/'){
                stack.push(n2/n1);
            }
        }
        return stack.pop();
    }
}
