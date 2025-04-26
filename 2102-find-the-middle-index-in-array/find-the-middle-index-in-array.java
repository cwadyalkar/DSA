class Solution {
    public int findMiddleIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        for (int num : nums) {
            rightSum = rightSum + num;
        }

        for (int i = 0; i < nums.length; i++) {
            rightSum = rightSum - nums[i];
            if(leftSum == rightSum){
                return i;
            }
            leftSum = leftSum + nums[i];
        }
        return-1;
    }
}