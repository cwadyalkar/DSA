class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int openBracket = 0;
        int closeBracket = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(ch);
            }else{
                if(stack.isEmpty() || stack.peek() == ')'){
                    stack.push(ch);
                }else{
                    stack.pop();
                }
            }
        }
        return stack.size();
    }
}