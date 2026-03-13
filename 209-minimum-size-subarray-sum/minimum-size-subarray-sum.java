class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum = sum + nums[end];
            System.out.println(sum);
            while (sum >= target) {
                min = Math.min(min, end - start + 1);
                sum = sum - nums[start];
                start++;
            }
            System.out.println(sum);
            
            end++;
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}