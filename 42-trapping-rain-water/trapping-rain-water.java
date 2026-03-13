class Solution {
    public int trap(int[] height) {
        int h = height.length;
        int left = 0;
        int right = h - 1;
        int rightMax = 0;
        int leftMax = 0;
        int water = 0;

        while(left < right){
            if(height[left] < height[right]){
                if(height[left] > leftMax){
                    leftMax = height[left];
                }else{
                    water += leftMax - height[left];
                }
                System.out.println(leftMax);
                left++;
            }else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }else{
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;


    }
}