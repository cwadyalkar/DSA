class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        // if length of the both array is not same then return false
        if (s.length() != t.length())
            return false;
        // P A P E R -----> T I T L E

        for (int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);

            if (!map.containsKey(original)) {
                if (!map.containsValue(replacement)) {
                    map.put(original, replacement);
                } else {
                    return false;
                }
            } else {
            // if both the original string is same but its replacement value is not same then return false
                char charMap = map.get(original);
                if (charMap != replacement)
                    return false;
            }
        }
        // else return true;
        return true;
    }
}