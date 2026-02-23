class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for(int i = 0;i < k;i++){
            sum = sum + nums[i];
        }
        double maxAverage = sum/k;
        int start = 0;
        int end = k - 1;
        while(end < nums.length-  1){
        
                sum = sum - nums[start];
                start++;
                end++;
                sum = sum + nums[end];

                 double currAverage = sum / k;
                maxAverage = Math.max(maxAverage,currAverage);
        }
        return maxAverage;
    }
}