class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = { -1, -1 };
        int leftIndex = findIndex(nums, target, true);
        int rightIndex = findIndex(nums, target, false);
        ans[0] = leftIndex;
        ans[1] = rightIndex;
        return ans;

    }

    public int findIndex(int nums[], int target, boolean isLeft) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                index = mid;
                if (isLeft) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return index;
    }
}