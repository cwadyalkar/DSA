class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int bracket = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                bracket++;
                max = Math.max(max, bracket);
            } else if (ch == ')') {
                bracket--;
            }
        }
        return max;
    }
}