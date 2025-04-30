class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    public void backtrack(List<String> result, String current, int left, int right, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        if (left < max) {
            backtrack(result, current + "(", left + 1, right, max);
        }
        if (left > right) {
            backtrack(result, current + ")", left, right + 1, max);
        }
    }
}