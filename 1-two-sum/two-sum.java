class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result[] = new int[2];
        for (int num = 0; num < nums.length; num++) {
            int twoSum = target - nums[num];
            if (map.containsKey(twoSum)) {
                result[0] = map.get(twoSum);
                result[1] = num;
            }
            map.put(nums[num], num);
        }

        return result;
    }
}