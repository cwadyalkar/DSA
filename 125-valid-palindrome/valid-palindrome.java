class Solution {
    public boolean isPalindrome(String s) {
     String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(cleaned); 
        int left = 0;
        int right = cleaned.length() - 1;

    while(left <= right){
        char leftChar = cleaned.charAt(left);
        char rightChar = cleaned.charAt(right);
        if(leftChar == rightChar){
            left++;
            right--;
        }else{
            return false;
        }
    } 
      return true;
    }

}