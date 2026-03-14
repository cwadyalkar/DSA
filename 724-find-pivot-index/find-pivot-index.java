class Solution {
    public int pivotIndex(int[] nums) {
        int prefixSum = 0;
        int suffixSum = 0;

        for (int num : nums) {
            suffixSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if(prefixSum == suffixSum){
                return i;
            }
            suffixSum -= nums[i];
        }
        return -1;
    }
}