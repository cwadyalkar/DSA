class Solution {
    public static final Map<Character, String> phonemap = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz");

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(0, new StringBuilder(), digits, result);
        return result;
    }

    public void backtrack(int index, StringBuilder current, String digits, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String possibleLetters = phonemap.get(digits.charAt(index));
        for (char letter : possibleLetters.toCharArray()) {
            current.append(letter);
            backtrack(index + 1, current, digits, result);
            current.deleteCharAt(current.length() - 1);
        }

    }
}