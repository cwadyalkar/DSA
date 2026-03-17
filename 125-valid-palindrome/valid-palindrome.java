class Solution {
    public boolean isPalindrome(String s) {
        String newStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0;
        int j = newStr.length() - 1;
        while (i < j) {
            char start = newStr.charAt(i);
            char end = newStr.charAt(j);
            if (start != end) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}