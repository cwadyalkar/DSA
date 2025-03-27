class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            map.put(chS, map.getOrDefault(chS, 0) + 1);
            map.put(chT, map.getOrDefault(chT, 0) - 1);

        }
        for (int val : map.values()) {
            if (val != 0) {
                return false;
            }
        }
        return true;

    }
}