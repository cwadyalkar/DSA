class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int start = 0;
        int end = k - 1;
        double sum = 0;

        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }
        double maxAverage = sum / k;
        while (end < nums.length - 1) {
            sum -= nums[start];
            start++;
            end++;
            sum += nums[end];
            double currAvg = sum / k;
            maxAverage = Math.max(currAvg, maxAverage);

        }

        return maxAverage;
    }
}