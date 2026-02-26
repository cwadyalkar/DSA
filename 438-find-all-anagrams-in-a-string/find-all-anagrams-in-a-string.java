class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        if(s.length() < p.length()) return list;
        int referenceArr[] = new int[26];
        int compareArr[] = new int[26];
        int start = 0;
       
        for(int i = 0;i < p.length();i++){
            referenceArr[p.charAt(i) - 'a']++;
            compareArr[s.charAt(i) - 'a']++;
          
        }
        for(int end = p.length();end<=s.length();end++){
           boolean isEqual = Arrays.equals(referenceArr, compareArr);
           if(isEqual){
            list.add(start);
           }
           if(end == s.length()) break;
           char endChar = s.charAt(end);
           compareArr[endChar - 'a']++;
           
           char startChar = s.charAt(start);
           compareArr[startChar - 'a']--;
           start++;
        }


        System.out.println(Arrays.toString(referenceArr));
        System.out.println(Arrays.toString(compareArr));
        return list;
    }
}