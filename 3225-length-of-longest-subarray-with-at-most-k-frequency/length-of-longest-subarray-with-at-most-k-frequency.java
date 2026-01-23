class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int len = 0;
        int maxlen = 0;

        while (end < nums.length) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);

            while(map.get(nums[end]) > k){
                map.put(nums[start],map.get(nums[start])-1);
                start++;
            }
            maxlen = Math.max(maxlen, end - start + 1);
            end++;
        }
        return maxlen;
    }
}