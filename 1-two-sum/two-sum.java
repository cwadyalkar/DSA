class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int secondVal = target - nums[i];
            if(map.containsKey(secondVal)){
                int val = map.get(secondVal);
                ans[0] = val;
               ans[1] = i;
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}