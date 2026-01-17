class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int votes = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                votes++;
            } else {
                if (votes == 1) {
                    candidate = nums[i];
                } else {

                    votes--;
                }
            }
        }
        return candidate;
    }
}