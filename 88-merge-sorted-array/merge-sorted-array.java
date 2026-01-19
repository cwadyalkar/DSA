class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = m - 1;
        int n2 = n - 1;
        int lastIndex = m + n -1;
        while(n1 >= 0 && n2 >= 0){
            if(nums1[n1] < nums2[n2]){
                nums1[lastIndex] = nums2[n2];
                n2--;
                
            }else{
                nums1[lastIndex] = nums1[n1];
                n1--;
            }
            lastIndex--;
        }

        while(n2 >= 0){
                nums1[lastIndex] = nums2[n2];
                lastIndex--;
                n2--;
        }
    }
}