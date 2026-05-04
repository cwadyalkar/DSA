class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        
        int first = x;
        int second = reverse(x);
        System.out.println(second);
        return first == second;
    }
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int modulo = x % 10;
            if(rev >= Integer.MAX_VALUE/10 || rev <= Integer.MIN_VALUE/10) return 0;
            rev = (rev * 10) + modulo;
            x = x / 10;
        }
        return rev;
    }
}