class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            System.out.println(ch1);
            System.out.println(ch2);
            map.put(ch1,map.getOrDefault(ch1,0)+1);
                        System.out.println(map);

            map.put(ch2,map.getOrDefault(ch2,0)-1);
            

        }
        for(int ele : map.values()){
                if(ele != 0){
                    return false;
                }
            }
        return true;
    }
}