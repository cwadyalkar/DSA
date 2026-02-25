class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n2 = nums2.length;
        int n1 = nums1.length;
        for(int i = n2-1;i >= 0;i--){
            int ele = nums2[i];

            while(!stack.isEmpty() && ele > stack.peek()){
                stack.pop();
            }
            map.put(ele,stack.isEmpty() ? -1 : stack.peek());
            stack.push(ele);
            System.out.println(map.get(ele));
        }
        int ans[] = new int[n1];
        for(int i = 0;i < n1;i++){
            int ele = nums1[i];
            // System.out.println(map);
            ans[i] = map.get(ele);

        }
        return ans;
    }
}