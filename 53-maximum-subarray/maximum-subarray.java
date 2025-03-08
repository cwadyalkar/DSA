class Solution {
    public int maxSubArray(int[] nums) {
        int maxCount = nums[0];
        int currSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            currSum = Math.max(nums[i],currSum+nums[i]);
            maxCount = Math.max(maxCount,currSum);
        }
        return maxCount;


        // using kadanes algorithm
    }
}