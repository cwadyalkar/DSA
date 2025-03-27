class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int counter = 0;

        for (char str : s.toCharArray()) {
            if (str == '(') {
                if(counter > 0){
                    ans.append(str);
                }
                counter++;
            }else if(str == ')'){
                counter--;
                if(counter > 0){
                    ans.append(')');
                }
            }
        }

        return ans.toString();
    }

}