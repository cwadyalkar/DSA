class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int original = x;
        int palindrome = 0;
        while (x != 0) {
            int modulo = x % 10;
            x = x / 10;
            palindrome = (palindrome * 10) + modulo;

        }
        return original == palindrome;

    }
}