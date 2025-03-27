class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 && strs == null) {
            return "";
        }
        Arrays.sort(strs);
        String start = strs[0];
        String end = strs[strs.length - 1];
        int i = 0;
        while (i < start.length() &&  i < end.length() && start.charAt(i) == end.charAt(i)) {
            i++;
        }

        return start.substring(0, i);

    }
}