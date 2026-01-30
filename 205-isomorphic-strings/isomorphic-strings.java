class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char newS = s.charAt(i);
            char newT = t.charAt(i);
            if (map.containsKey(newS) && map.get(newS) != newT) {
                return false;
            } else {
                map.put(newS, newT);
            }

            if (map2.containsKey(newT) && map2.get(newT) != newS) {
                return false;
            } else {
                map2.put(newT, newS);
            }
        }
        return true;
    }
}