class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int i = 0;
        return findMax(nums,i,sum,max);
    }

    public int findMax(int nums[],int i,int sum,int max){
        if(i == nums.length) return max;
        sum = sum + nums[i];
        max = Math.max(sum,max);
        if(sum < 0){
           return findMax(nums,i+1,0,max);      
        }
        else{
            return findMax(nums,i+1,sum,max);
        }
    }

}