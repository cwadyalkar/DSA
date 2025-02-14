class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Step 1: Sort the array
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize with the first three elements

        for (int i = 0; i < nums.length - 2; i++) { 
            int left = i + 1, right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // If the sum is exactly equal to the target, return immediately
                if (sum == target) return sum;
                
                // Update the closest sum if found a better one
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }

                // Move pointers based on the sum
                if (sum < target) {
                    left++; // Increase sum
                } else {
                    right--; // Decrease sum
                }
            }
        }
        return closestSum;

    }
}