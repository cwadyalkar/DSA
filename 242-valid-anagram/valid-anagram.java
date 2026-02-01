class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            char sCh = s.charAt(i);
            map.put(sCh,map.getOrDefault(sCh,0)+1);            
        }

        for(int i = 0;i < t.length();i++){
            char tCh = t.charAt(i);
            map.put(tCh,map.getOrDefault(tCh,0)-1);            
        }

        for(int value : map.values()){
            if(value > 0){
                return false;
            }
        }

        return true;

    }
}