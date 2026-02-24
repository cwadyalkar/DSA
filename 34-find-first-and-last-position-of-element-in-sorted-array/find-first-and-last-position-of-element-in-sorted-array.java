class Solution {
    public int[] searchRange(int[] nums, int target) {
       int first = searchOccurence(nums,target,true);
       System.out.println(first);
       int second = searchOccurence(nums,target,false);
         System.out.println(second);

       return new int[]{first,second};
    }

    public int searchOccurence(int nums[],int target,boolean isFirstOccurence){
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target == nums[mid]){
                ans = mid;
                if(isFirstOccurence){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }

            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;

    }
}