class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxAmount = 0;
        while(i < j){
            int heightOfLine = Math.min(height[i],height[j]);
            int widthOfLine = j - i;
            int area = heightOfLine * widthOfLine;
            maxAmount = Math.max(maxAmount,area);
            if(height[i] <= height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxAmount;
    }
}