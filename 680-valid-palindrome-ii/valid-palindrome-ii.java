class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
       
        while(start <= end){
            char chStart = s.charAt(start);
            char chEnd = s.charAt(end);
            if(chStart == chEnd){
                start++;
                end--;
            }else{
                return isValidPalindrome(s,start+1,end) || isValidPalindrome(s,start,end-1); 
            }
        }
        return true;
    }
    public boolean isValidPalindrome(String s,int start,int end){
        while(start <= end){
            char chStart = s.charAt(start);
            char chEnd = s.charAt(end);
            if(chStart == chEnd){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
}