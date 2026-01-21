class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int prefix = 0;
        int suffix = 0;
        for(int num : nums){
            sum = sum + num;
        }


        for(int i = 0;i< nums.length;i++){
             suffix = sum - prefix - nums[i];

             if(suffix == prefix){
                return i;
             }
               prefix = prefix + nums[i];
        }
        return -1;
    }
}