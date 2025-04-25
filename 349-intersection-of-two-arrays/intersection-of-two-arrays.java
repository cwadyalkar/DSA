class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int n2 : nums2) {
            set.add(n2);

        }
        for (int n1 : nums1) {
            if (set.contains(n1)) {
                list.add(n1);
                set.remove(n1);
            }
        }
        int ans[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}