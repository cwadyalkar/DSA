class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        reverseHelper(s,left,right);
    }
    void reverseHelper(char[] s,int left,int right){
        if(left >= right) return;
        
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        reverseHelper(s,left+1,right-1);
    }
}