class Solution {
    public int numberOfSubstrings(String s) {
       int freq[] = new int[3];
       int result = 0;
       int count = 0;
       int start = 0;
        for(int end = 0;end < s.length();end++){
            char ch = s.charAt(end);
            int index = ch - 'a';
          if(freq[index] == 0) count++;
          freq[index]++;

            while(count == 3){
                result += s.length() - end;
                int startIndex = s.charAt(start) - 'a';
                freq[startIndex]--;
                if (freq[startIndex] == 0) count--;
                start++;
            }
        }
        return result;
    }
}