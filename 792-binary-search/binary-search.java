class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        return findRecursively(nums,target,start,end);
    }

    public int findRecursively(int nums[], int target, int start, int end) {
        if (start > end)
            return -1;
        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return findRecursively(nums, target, start, mid - 1);
        } else {
            return findRecursively(nums, target, mid + 1, end);
        }
    }
}