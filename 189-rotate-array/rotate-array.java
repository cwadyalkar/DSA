class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }

    public void reverse(int nums[],int i,int j){
        int x = i;
        int y = j;
        while(x <= y){
         swap(nums,x,y);
         x++;
         y--;
        }
    }
   
    public void swap(int nums[],int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}