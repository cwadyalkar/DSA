class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int start = 0;
        int minWindow = Integer.MAX_VALUE;

        for(int end = 0;end < nums.length;end++){
            sum = sum + nums[end];


            while(sum >= target){
                minWindow = Math.min(minWindow,end-start+1);
                sum = sum - nums[start];
                start++;
            }
        }
        return minWindow == Integer.MAX_VALUE ? 0 : minWindow;
    }
}