class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n2 = nums2.length;
        int[] result = new int[nums1.length];

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(nums2[n2 - 1]);
        map.put(nums2[n2 - 1], -1);

        for (int i = n2 - 2; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}
