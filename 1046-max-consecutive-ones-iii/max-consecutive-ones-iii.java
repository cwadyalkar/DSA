class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int zeroFlip = 0;
        int currLen = 0;
        int maxLen = 0;
        int start = 0;
        int end = 0;
        while(end < n){
            if(nums[end] == 0){
                zeroFlip++;
            }
            while(zeroFlip > k){
                if(nums[start] == 0) zeroFlip--;
                start++;
            }
            currLen = end - start + 1;
            maxLen = Math.max(maxLen,currLen);
            end++;
        }

        return maxLen;
        
    }
}