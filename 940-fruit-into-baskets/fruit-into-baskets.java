class Solution {
    public int totalFruit(int[] fruits) {
        int start = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = fruits.length;
        int max = Integer.MIN_VALUE;

        for (int end = 0; end < n; end++) {
            map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[start], map.getOrDefault(fruits[start], 0) - 1);
                if(map.get(fruits[start]) == 0) map.remove(fruits[start]);
                start++;
            }
            max = Math.max(max,end - start + 1);
        }
        return max;
    }
}