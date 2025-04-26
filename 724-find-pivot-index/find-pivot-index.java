class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        for (int sum : nums) {
            rightSum = rightSum + sum;
        }
        for (int i = 0; i < nums.length; i++) {
            rightSum = rightSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }
            leftSum = leftSum + nums[i];

        }
        return -1;
    }
}