class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        cycleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ans.add(i + 1);
            }
        }
        return ans;

    }

    public void cycleSort(int nums[]) {

        int index = 0;
        int n = nums.length;

        while (index < n) {
            int element = nums[index];
            int actualPos = element - 1;
            if (nums[actualPos] != nums[index]) {
                swap(nums, index, actualPos);
            } else {
                index++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}