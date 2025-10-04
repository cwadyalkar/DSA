class Solution {
    public boolean canJump(int[] nums) {
        int finalDestination = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int sum = i + nums[i];
            System.out.println("for sum------>" + sum);
            System.out.println("for destination------>" + finalDestination);
            if (i + nums[i] >= finalDestination) {

                finalDestination = i;
            }
        }
        System.out.println("for finalDestination------>" + finalDestination);

        return finalDestination == 0;
    }
}