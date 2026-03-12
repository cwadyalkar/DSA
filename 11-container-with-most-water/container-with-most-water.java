class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int max = Integer.MIN_VALUE;

        while(left < right){
            int area = Math.min(height[left],height[right]) * (right - left);
            max = Math.max(max,area);
            if(height[left] < height[right]){
                left++;
            }else if(height[right] < height[left]){
                right--;
            }else{
                left++;
                right--;
            }
        }

        return max;
    }
}