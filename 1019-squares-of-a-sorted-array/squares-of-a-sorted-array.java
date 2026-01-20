class Solution {
    public int[] sortedSquares(int[] nums) {
          int n = nums.length;
        int result[] = new int[n];

        int start = 0;
        int end = nums.length - 1;

        int k = result.length - 1;
        System.out.println(k);
   
    
        while (start <= end) {
                 int newStart = Math.abs(nums[start]);
        int newEnd = Math.abs(nums[end]);
            if (newStart < newEnd) {
                result[k] = newEnd * newEnd;
                end--;
            } else {
                result[k] = newStart * newStart;
                start++;
            }
               
            k--;
        }

        return result;
    }
}