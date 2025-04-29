class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, new ArrayList<>(), result);
        return result;
    }

    public void backTrack(int nums[], List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int num : nums) {
            if (tempList.contains(num))
                continue;
            tempList.add(num);
            backTrack(nums, tempList, result);
            tempList.remove(tempList.size() - 1);
        }
    }
}