class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        return findRecursively(nums,target,start,end);
    }
    public int findRecursively(int nums[],int target,int start,int end){
        int mid = start + (end - start)/2;
        System.out.println(mid);
        if(start > end) return -1;
         System.out.println("start"+start+" "+"end"+end);

        if(nums[mid] == target) return mid;
        if(nums[start] <= nums[mid]){
            if(target >= nums[start] && target < nums[mid]){
                return findRecursively(nums,target,start,mid-1);
            }else{
                return findRecursively(nums,target,mid+1,end);
            }

        }else{
            if(target > nums[mid] && target <= nums[end]){
                return findRecursively(nums,target,mid+1,end);
            }else{
                return findRecursively(nums,target,start,mid-1);
            }

        }
    }
}