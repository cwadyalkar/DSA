class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (k > j && j < n - 1 && nums[k] == nums[k + 1]) k--;

                } else if (sum < 0) {
                    j++;
                } else {
                    k--;  
                }
            }
        }
        return result;
    }
}