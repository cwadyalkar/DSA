class Solution {
    public int majorityElement(int[] nums) {
        int votes = 1;
        int majorityEle = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i] == majorityEle){
                votes++;
            }else{
               votes--;
               if(votes == 0){
                majorityEle = nums[i];
                votes++;
               }
            }
        }
        return majorityEle;
    }
}