class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int len = 0;
        int left = 0;
        for(int right = 0;right < s.length();right++){
            char ch = s.charAt(right);
            System.out.println(ch);
            if(map.containsKey(ch)){
                left = Math.max(left,map.get(ch)+1);
            }
            len =  Math.max(right - left + 1,len);
            map.put(ch,right);
        }

        return len;
        
    }
}