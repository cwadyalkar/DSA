class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (x == 0) return 0.0;
        if (x == 1) return 1.0;
        if (x == -1) return (n % 2 == 0) ? 1.0 : -1.0;
        
        long exp = n; 
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }

        double ans = 1.0;
        while (exp > 0) {
            if (exp % 2 == 1) {
                ans *= x;
            }
            x *= x;
            exp /= 2;
        }
        return ans;
    }
}


// i have to revised it once