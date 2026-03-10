class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int prefixSum = 0;
        int suffixSum = 0;
        for (int i = 0; i < n; i++) {
            suffixSum = suffixSum + nums[i];
        }

        for (int i = 0; i < n; i++) {
            prefixSum = prefixSum + nums[i];
            if (suffixSum == prefixSum) {
                return i;
            }
            suffixSum = suffixSum - nums[i];
        }

        return -1;

    }
}